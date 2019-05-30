package view.yut_game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class ThrowButton extends JButton implements ActionListener
{	
	ViewBoard VB = new ViewBoard();
	
	public void ThrowButton(String text)
	{
		setText(text);
		addActionListener(this);
	}
	
	//도, 개, 걸, 윷, 모, 백도  변수 
	static Random generator = new Random();
	static int randomYut= generator.nextInt(100);
	
	//버튼을 누를때 도개걸윷모 이미지가 나오고 Player 1,Player 2를 바꿔주는 메소드 
	public void actionPerformed(ActionEvent e)
	{
		if (0 <= randomYut && randomYut <= 3)
		{
			ImageIcon image0 = new ImageIcon ("src/img/뒷도.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image0 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(4 <= randomYut && randomYut <= 14)
		{
			ImageIcon image1 = new ImageIcon ("src/img/도.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image1 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(15 <= randomYut && randomYut <= 49)
		{
			ImageIcon image2 = new ImageIcon ("src/img/개.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image2 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(50 <= randomYut && randomYut <= 84)
		{
			ImageIcon image3 = new ImageIcon ("src/img/걸.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image3 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(85 <= randomYut && randomYut <= 97)
		{
			ImageIcon image4 = new ImageIcon ("src/img/윷.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image4 );
			JOptionPane.showMessageDialog(null, "Once More");
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
			}
			else
			{
				VB.change2();
			}
			randomYut = generator.nextInt(100);
			set();
		}
		else if(98 <= randomYut && randomYut <= 99)
		{
			ImageIcon image5 = new ImageIcon ("src/img/모.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image5 );
			JOptionPane.showMessageDialog(null, "Once More");
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
			}
			else {
				VB.change2();
			}
			randomYut = generator.nextInt(100);
			set();
		}
		ViewTurn.TURN.repaint();
	}
	
	// 윷 모 가나왔을때 한번더 윷을 던지게하는 메소드 
	public void set()
	{
		if (0 <= randomYut && randomYut <= 3)
		{
			ImageIcon image0 = new ImageIcon ("src/img/뒷도.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image0 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(4 <= randomYut && randomYut <= 14)
		{
			ImageIcon image1 = new ImageIcon ("src/img/도.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image1 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(15 <= randomYut && randomYut <= 49)
		{
			ImageIcon image2 = new ImageIcon ("src/img/개.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image2 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(50 <= randomYut && randomYut <= 84)
		{
			ImageIcon image3 = new ImageIcon ("src/img/걸.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image3 );
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
				ViewTurn.setplayer("Player 2");
			}
			else
			{
				VB.change2();
				ViewTurn.setplayer("Player 1");
			}
			randomYut = generator.nextInt(100);
		}
		else if(85 <= randomYut && randomYut <= 97)
		{
			ImageIcon image4 = new ImageIcon ("src/img/윷.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image4 );
			JOptionPane.showMessageDialog(null, "Once More");
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
			}
			else
			{
				VB.change2();
			}
			randomYut = generator.nextInt(100);
			set();
		}
		else if(98 <= randomYut && randomYut <= 99)
		{
			ImageIcon image5 = new ImageIcon ("src/img/모.jpg");
			JOptionPane.showMessageDialog(null, "", "윷", JOptionPane.INFORMATION_MESSAGE, image5 );
			JOptionPane.showMessageDialog(null, "Once More");
			if(ViewTurn.getplayer() == "Player 1")
			{
				VB.change();
			}
			else {
				VB.change2();
			}
			randomYut = generator.nextInt(100);
			set();
		}
		ViewTurn.TURN.repaint();
	}
}