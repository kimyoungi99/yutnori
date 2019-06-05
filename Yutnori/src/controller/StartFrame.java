package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame {
	private SelectButton[] playerSelectButton = new SelectButton[3];
	private SelectButton[] pieceSelectButton = new SelectButton[4];
	private SelectButton startButton = new SelectButton(3);
	//private Controller controller;
	private int numOfPlayer = 4;
	private int numOfPiece = 4;
	
	public StartFrame() {
		JPanel playerSelectionPanel = new JPanel();
		JPanel pieceSelectionPanel = new JPanel();
		JPanel startPanel = new JPanel();
		this.setBounds(150, 100, 300, 150);
		this.setLayout(new GridLayout(3, 0));
		playerSelectionPanel.setBounds(0, 0, 250, 50);
		pieceSelectionPanel.setBounds(50, 0, 250, 50);
		startPanel.setBounds(100, 0, 250, 50);
		this.add(playerSelectionPanel);
		this.add(pieceSelectionPanel);
		this.add(startPanel);
		
		for(int i = 0; i < 3; i++) {
			this.playerSelectButton[i] = new SelectButton(i+1, 0);
			this.playerSelectButton[i].setStartFrame(this)
;			playerSelectionPanel.add(this.playerSelectButton[i]);
		}
		for(int i = 0; i < 4; i++) {
			this.pieceSelectButton[i] = new SelectButton(i+1, 1);
			this.pieceSelectButton[i].setStartFrame(this);
			pieceSelectionPanel.add(this.pieceSelectButton[i]);
		}
		startButton.setText("Start");
		startButton.setStartFrame(this);
		startPanel.add(startButton);
	}
	
	public static void main(String[] args) {
		StartFrame start = new StartFrame();
		start.setVisible(true);
		//FinalFrame finalframe = new FinalFrame(0);
		//finalframe.setVisible(true);
	}
	
	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public void setNumOfPiece(int numOfPiece) {
		this.numOfPiece = numOfPiece;
	}
	
	/*
	public Controller getController() {
		return controller;
	}
	*/
	
	public void startGame() {
		Controller controller = new Controller(numOfPlayer, numOfPiece);
		controller.init();
		controller.setVisible(true);
	}
}
