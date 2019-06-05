package controller;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame {
	SelectButton[] playerSelectButton = new SelectButton[4];
	SelectButton[] pieceSelectButton = new SelectButton[5];
	private int np = 4;
	
	private StartFrame() {
		JPanel pls = new JPanel();
		JPanel pis = new JPanel();
		this.setBounds(100, 100, 300, 150);
		this.setLayout(new GridLayout(2, 0));
		pls.setBounds(0, 0, 250, 50);
		pis.setBounds(50, 0, 250, 50);
		this.add(pls);
		this.add(pis);
		
		for(int i = 0; i < 4; i++) {
			this.playerSelectButton[i] = new SelectButton(i, 0);
			this.playerSelectButton[i].setSB(this)
;			pls.add(this.playerSelectButton[i]);
		}
		for(int i = 0; i < 5; i++) {
			this.pieceSelectButton[i] = new SelectButton(i, 1);
			this.pieceSelectButton[i].setSB(this);
			pis.add(this.pieceSelectButton[i]);
		}
		
	}
	
	public static void main(String[] args) {
		StartFrame start = new StartFrame();
		start.setVisible(true);
	}
	
	public void setNumOfPlayer(int i) {
		this.np = i;
	}
	
	public void startGame(int npi) {
		Controller controller = new Controller(this.np, npi);
		controller.init();
		controller.setVisible(true);
	}
}
