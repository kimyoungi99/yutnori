package controller;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinalFrame extends JFrame{
	private SelectButton restartButton = new SelectButton(4);
	private SelectButton exitButton = new SelectButton(5);
	private ImageIcon defaultImage[] = new ImageIcon[4];
	
	public FinalFrame(int winner, StartFrame startFrame) {
		for(int i=0; i<defaultImage.length; i++) {
			String address = "src/view/img/";
			address = address + Integer.toString(i+1) + "-1.png";
			defaultImage[i] = new ImageIcon(address);
		}
		
		JPanel winnerPanel = new JPanel();
		JPanel selectionPanel = new JPanel();
		JLabel winnerLabel = new JLabel();
		JLabel winnerText = new JLabel();
		this.setBounds(300, 500, 300, 185);
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
		
		winnerLabel.setBounds(60, 15, 100, 54);
		winnerText.setFont(new Font("Helvetica", Font.BOLD, 20));
		winnerText.setBounds(120, 20, 100, 54);

		restartButton.setText("Restart");
		exitButton.setText("Exit");
		
		restartButton.setFinalFrame(this);
		restartButton.setStartFrame(startFrame);
		//startButton.setStartFrame(this);
		selectionPanel.add(restartButton);
		selectionPanel.add(exitButton);
	}
	
	public void restartGame() {

	}
	
	public void exitGame() {
		System.exit(0);
	}
}
