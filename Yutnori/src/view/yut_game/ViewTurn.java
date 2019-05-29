package yut_game;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewTurn extends JPanel
{
	public static JLabel TURN = new JLabel("Player 1");
	
	public ViewTurn()
	{
		add(TURN, BorderLayout.WEST);
		ThrowButton TB = new ThrowButton();
		TB.ThrowButton("THROW");
		add(TB);
	}
	
	public static String getplayer()
	{
		return TURN.getText();
	}

	public static void setplayer(String s)
	{
		TURN.setText(s);
	}
}