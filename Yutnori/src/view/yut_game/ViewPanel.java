package yut_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPanel extends JButton
{	
	private ImageIcon image = new ImageIcon();
	public static int i = 0;
	public static int j = 0;
	public static String s = "";
	public static JPanel Board = new JPanel();
	
	public ViewPanel(int i, String s)
	{
		if 		(s == "YutBoard1")	  	IMAGE("YutBoard1");
		else if	(s == "YutBoard2")		IMAGE("YutBoard2");
		else if	(s == "YutBoard1_p1")	IMAGE("YutBoard1_p1");
		else if	(s == "YutBoard1_p2")	IMAGE("YutBoard1_p2");
		else if	(s == "YutBoard2_p1")	IMAGE("YutBoard2_p1");
		else if	(s == "YutBoard2_p2")	IMAGE("YutBoard2_p2");
		else 							IMAGE("YutBoard1");		
		
		setLayout(null);
		
		JButton BoardCell = new JButton(image);
		BoardCell.setBounds(0, 0, 99, 99);
		BoardCell.setOpaque(false);
		BoardCell.setBorderPainted(false);
		
		add(BoardCell);
		setVisible(true);
		setOpaque(false);
		setFocusable(true);
	}
	
	public static String setimage(int i)
	{
		String setboard = "";
		if 		(getimage(i) == "YutBoard1") 	setboard = "YutBoard1";
		else if	(getimage(i) == "YutBoard2") 	setboard = "YutBoard2";
		else if	(getimage(i) == "YutBoard1_p1") setboard = "YutBoard1_p1";
		else if	(getimage(i) == "YutBoard1_p2") setboard = "YutBoard1_p2";
		else if	(getimage(i) == "YutBoard2_p1") setboard = "YutBoard2_p1";
		else if	(getimage(i) == "YutBoard2_p2") setboard = "YutBoard2_p2";
		return setboard;
	}
	
	public static String getimage(int i)
	{
		return s;
	}
	
	public void IMAGE(String filename)
	{
		image = new ImageIcon("src/img/" + filename + ".png");
	}
}