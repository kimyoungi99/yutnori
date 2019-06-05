package controller;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinalFrame extends JFrame{
	private SelectButton restartButton = new SelectButton(3);
	private SelectButton exitButton = new SelectButton(4);
	private ImageIcon defaultImage[] = new ImageIcon[4];
	
	public FinalFrame(int winner) {
		for(int i=0; i<defaultImage.length; i++) {
			String address = "src/view/img/";
			address = address + Integer.toString(i+1) + "-1.png";
			defaultImage[i] = new ImageIcon(address);
		}
		
		JPanel winnerPanel = new JPanel();
		JPanel selectionPanel = new JPanel();
		JLabel winnerLabel = new JLabel();
		JLabel winnerText = new JLabel();
		this.setBounds(150, 100, 300, 185);
		this.setLayout(new GridLayout(2, 0));
		winnerPanel.setBounds(0, 0, 250, 160);
		selectionPanel.setBounds(180, 0, 250, 25);
		this.add(winnerPanel);
		this.add(selectionPanel);
		
		winnerPanel.setLayout(null);
		winnerLabel.setIcon(defaultImage[winner]);
		winnerText.setText("is Winner");
		winnerPanel.add(winnerLabel);
		winnerPanel.add(winnerText);
		
		winnerLabel.setBounds(80, 15, 100, 54);
		//winnerText.setFont(new Font("Serif", Font.PLAIN, 14));
		winnerText.setBounds(140, 20, 54, 54);

		restartButton.setText("Restart");
		exitButton.setText("Exit");
		//startButton.setStartFrame(this);
		selectionPanel.add(restartButton);
		selectionPanel.add(exitButton);
	}
	
	
	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public void setNumOfPiece(int numOfPiece) {
		this.numOfPiece = numOfPiece;
	}
	
	public void startGame() {
		Controller controller = new Controller(numOfPlayer, numOfPiece);
		controller.init();
		controller.setVisible(true);
	}
}
