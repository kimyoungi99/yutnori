package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.Model;
import view.yut_game.ViewTurn;

public class View extends JFrame{
	private Model model = new Model();
	private Controller controller = new Controller(model);
	
	public View(JPanel boardPanel, ViewTurn VT)
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
	
	public void paint() {
		
	}
	
	public void repaint() {
		
	}
}
