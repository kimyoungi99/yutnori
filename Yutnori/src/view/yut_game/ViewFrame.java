package view.yut_game;

import java.awt.*;
import javax.swing.*;

public class ViewFrame extends JFrame
{
	public ViewFrame(JPanel boardPanel, ViewTurn VT)
	{	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(boardPanel, BorderLayout.CENTER);
		c.add(VT, BorderLayout.SOUTH);
		c.setBackground(Color.WHITE);
		
		setTitle("Yot No Ri");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}