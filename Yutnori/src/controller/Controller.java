package controller;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CONSTANT;
import model.Model;
import model.Player;
import model.Tile;
import view.View;

public class Controller extends JFrame {
	private Model model = new Model();
	private View view;
	private GameBoardPanel gameBoardPanel = new GameBoardPanel(model);
	private GameInfoPanel gameInfoPanel = new GameInfoPanel(model);
	private JPanel throwButtonPanel = new JPanel();
	private JPanel restPiecePanel = new JPanel();
	private JPanel throwResultPanel = new JPanel();
	private RestPieceButton[][] restPieceButton = new RestPieceButton[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
	private ThrowButton[] throwButton = new ThrowButton[7];
	private JLabel throwResultLabel = new JLabel();
	private ImageIcon moeImage = new ImageIcon("src/view/img/First.png");
	private ImageIcon defaultImage[] = new ImageIcon[4];

	public Controller(int playerNum, int PieceNum) {
		CONSTANT c = new CONSTANT(playerNum, PieceNum);
		this.setTitle("Yut No Ri");
		this.setBounds(300, 30, 990, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		// this.setVisible(true);
		view = new View();
		view.setController(this);
		for (int i = 0; i < CONSTANT.PLAYERNUM; i++) {
			model.getPlayer()[i].addObserver(view);	
		}
		for(int i=0; i<defaultImage.length; i++) {
			String address = "src/view/img/";
			address = address + Integer.toString(i+1) + "-1.png";
			defaultImage[i] = new ImageIcon(address);
		}
	}

	public void init() {
		model.getTurnPlayer().addNumOfThrowChance();
		gameBoardPanel.setBackground(Color.WHITE);
		gameBoardPanel.setBounds(25, 75, 610, 610);
		
		gameInfoPanel.setBounds(25, 5, 610, 65);

		GridLayout restPiecePanelLayout = new GridLayout(CONSTANT.PLAYERNUM, CONSTANT.PIECENUM);
		restPiecePanel.setLayout(restPiecePanelLayout);
		for (int i = 0; i < CONSTANT.PLAYERNUM; i++) {
			for (int j = 0; j < CONSTANT.PIECENUM; j++) {
				restPieceButton[i][j] = new RestPieceButton(i, j, model);
				restPieceButton[i][j].setIcon(defaultImage[i]);
				restPiecePanel.add(restPieceButton[i][j]);
			}
		}

		restPiecePanel.setBounds(670, 75, 54*CONSTANT.PIECENUM, 54*CONSTANT.PLAYERNUM);

		throwResultLabel.setIcon(moeImage);
		throwResultPanel.add(throwResultLabel);
		throwResultPanel.setBounds(695, 315, 220, 220);

		GridLayout throwYutButtonPanelLayout = new GridLayout(2, 4);
		throwButtonPanel.setLayout(throwYutButtonPanelLayout);
		for (int i = 0; i < throwButton.length; i++) {
			throwButton[i] = new ThrowButton(i, model);
			throwButton[i].setSize(20, 20);
			throwButtonPanel.add(throwButton[i]);
		}
		throwButtonPanel.setBounds(670, 565, 270, 110);

		this.add(gameBoardPanel);
		this.add(gameInfoPanel);
		this.add(restPiecePanel);
		this.add(throwResultPanel);
		this.add(throwButtonPanel);
		
		view.updateBoard(model.getPlayer()[0].yutnori.getBoard());
	}

	public Model getModel() {
		return model;
	}
	
	public JLabel getThrowResultLabel() {
		return throwResultLabel;
	}
	
	public JPanel getThorwResultPanel() {
		return throwResultPanel;
	}
	
	public GameBoardPanel getGameBoardPanel() {
		return gameBoardPanel;
	}
	
	public RestPieceButton[][] getRestPieceButton() {
		return this.restPieceButton;
	}
}
