package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	private View view = new View();
	
	public Frame()
	{	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(view, BorderLayout.CENTER);
		c.setBackground(Color.WHITE);
		
		setTitle("Yot No Ri");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
