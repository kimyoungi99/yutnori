package view;

import javax.swing.JPanel;

import model.Model;

public class GameBoardPanel extends JPanel{
	private TileButton[][] tileButton = new TileButton[6][5];
	private ExitButton exitButton;
	private static final int TILESIZE = 54;

	public GameBoardPanel(StartFrame sf) {
		this.setLayout(null);
		exitButton = new ExitButton(sf);
		for(int i=0; i<tileButton.length; i++) {
			for(int j=0; j<tileButton[0].length; j++) {
				tileButton[i][j] = new TileButton(i, j);
				this.add(tileButton[i][j]);
			}
		}
		this.add(exitButton);
			
		tileButton[0][0].setBounds(530, 530, TILESIZE, TILESIZE);
		tileButton[0][1].setBounds(530, 430, TILESIZE, TILESIZE);
		tileButton[0][2].setBounds(530, 330, TILESIZE, TILESIZE);
		tileButton[0][3].setBounds(530, 230, TILESIZE, TILESIZE);
		tileButton[0][4].setBounds(530, 130, TILESIZE, TILESIZE);
		tileButton[1][0].setBounds(530, 30, TILESIZE, TILESIZE);
		tileButton[1][1].setBounds(430, 30, TILESIZE, TILESIZE);
		tileButton[1][2].setBounds(330, 30, TILESIZE, TILESIZE);
		tileButton[1][3].setBounds(230, 30, TILESIZE, TILESIZE);
		tileButton[1][4].setBounds(130, 30, TILESIZE, TILESIZE);
		tileButton[2][0].setBounds(30, 30, TILESIZE, TILESIZE);
		tileButton[2][1].setBounds(30, 130, TILESIZE, TILESIZE);
		tileButton[2][2].setBounds(30, 230, TILESIZE, TILESIZE);
		tileButton[2][3].setBounds(30, 330, TILESIZE, TILESIZE);
		tileButton[2][4].setBounds(30, 430, TILESIZE, TILESIZE);
		tileButton[3][0].setBounds(30, 530, TILESIZE, TILESIZE);
		tileButton[3][1].setBounds(130, 530, TILESIZE, TILESIZE);
		tileButton[3][2].setBounds(230, 530, TILESIZE, TILESIZE);
		tileButton[3][3].setBounds(330, 530, TILESIZE, TILESIZE);
		tileButton[3][4].setBounds(430, 530, TILESIZE, TILESIZE);
		tileButton[5][0].setBounds(113, 113, TILESIZE, TILESIZE);
		tileButton[5][1].setBounds(196, 196, TILESIZE, TILESIZE);
		tileButton[5][2].setBounds(279, 279, TILESIZE, TILESIZE);
		tileButton[5][3].setBounds(362, 362, TILESIZE, TILESIZE);
		tileButton[5][4].setBounds(445, 445, TILESIZE, TILESIZE);
		tileButton[4][0].setBounds(445, 113, TILESIZE, TILESIZE);
		tileButton[4][1].setBounds(362, 196, TILESIZE, TILESIZE);
		tileButton[4][3].setBounds(196, 362, TILESIZE, TILESIZE);
		tileButton[4][4].setBounds(113, 445, TILESIZE, TILESIZE);
		exitButton.setBounds(280, 445, TILESIZE, TILESIZE);
	}
	
	public TileButton[][] getTileButton() {
		return tileButton;
	}
	
	public ExitButton getExitButton() {
		return exitButton;
	}
}
