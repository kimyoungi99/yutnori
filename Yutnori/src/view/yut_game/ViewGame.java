package yut_game;

import javax.swing.JPanel;

public class ViewGame
{
	public static void main(String[] args)
	{
		ViewPanel VP = new ViewPanel(0, null);
		ViewTurn VT = new ViewTurn();
		ViewFrame VF = new ViewFrame(VP.Board, VT);
	}
}