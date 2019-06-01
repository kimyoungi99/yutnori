package controller;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;
import model.Player;
import view.View;

public class Controller extends JFrame {
	private Model model = new Model();
	private View view;
	private JPanel gameBoardPanel = new JPanel();
	private JPanel throwButtonPanel = new JPanel();
	private JPanel restPiecePanel = new JPanel();
	private JPanel throwResultPanel = new JPanel();
	private JButton[][] restPieceButton = new JButton[4][4];
	private ThrowButton[] throwButton = new ThrowButton[7];
	private JLabel throwResultLabel = new JLabel();
	private ImageIcon moeImage = new ImageIcon("src/view/img/Moe.jpg");
	private Player player = new Player(1);

	public Controller() {
		this.setTitle("Yut No Ri");
		this.setBounds(100, 100, 1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		// this.setVisible(true);
		view = new View();
		view.setController(this);
		for (int i = 0; i < 4; i++) {
			model.getPlayer()[i].addObserver(view);	
		}
	}

	public void init() {
		gameBoardPanel.setBackground(Color.WHITE);
		gameBoardPanel.setBounds(25, 25, 610, 610);

		GridLayout restPiecePanelLayout = new GridLayout(4, 4);
		restPiecePanel.setLayout(restPiecePanelLayout);
		for (int i = 0; i < restPieceButton.length; i++) {
			for (int j = 0; j < restPieceButton[0].length; j++) {
				restPieceButton[i][j] = new JButton();
				restPiecePanel.add(restPieceButton[i][j]);
			}

		}
		restPiecePanel.setBounds(700, 10, 220, 220);

		throwResultLabel.setIcon(moeImage);
		throwResultPanel.add(throwResultLabel);
		throwResultPanel.setBounds(700, 250, 220, 220);

		GridLayout throwYutButtonPanelLayout = new GridLayout(2, 4);
		throwButtonPanel.setLayout(throwYutButtonPanelLayout);
		for (int i = 0; i < throwButton.length; i++) {
			throwButton[i] = new ThrowButton(i, model);
			throwButton[i].setSize(20, 20);
			throwButtonPanel.add(throwButton[i]);
		}
		throwButtonPanel.setBounds(700, 500, 220, 110);

		this.add(gameBoardPanel);
		this.add(restPiecePanel);
		this.add(throwResultPanel);
		this.add(throwButtonPanel);
		
		//model.addObserver(view);
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
}
