package view.yut_game;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewBoard extends ViewPanel
{	
	public static JButton[] BoardCell = new JButton[35];

	static HashMap<Integer, Integer> boardx = new HashMap();
	static HashMap<Integer, Integer> boardy = new HashMap();
	
	public ViewBoard()
	{
		super(i, s);
		
		Board.setLayout(null);
		Board.setOpaque(false);
		Board.setBounds(0, 0, 600, 600);
		
		setImg();	    
		setBound();
		BoardCellAdd();
	}
	
	public static void setpos()
	{
		  boardx.put(0, 514);
		  boardx.put(1, 514);
		  boardx.put(2, 514);
		  boardx.put(3, 514);
		  boardx.put(4, 514);
		  boardx.put(5, 514);
		  
		  boardx.put(6, 415);
		  boardx.put(7, 316);
		  boardx.put(8, 217);
		  boardx.put(9, 118);
		  boardx.put(10, 19);
		  
		  boardx.put(11, 19);
		  boardx.put(12, 19);
		  boardx.put(13, 19);
		  boardx.put(14, 19);
		  boardx.put(15, 19);
		  
		  boardx.put(16, 118);
		  boardx.put(17, 217);
		  boardx.put(18, 316);
		  boardx.put(19, 415);
		  
		  boardx.put(20, 415);
		  boardx.put(21, 343);
		  boardx.put(22, 268);
		  boardx.put(23, 193);
		  boardx.put(24, 118);
		  boardx.put(25, 118);
		  boardx.put(26, 193);
		  boardx.put(27, 268);
		  boardx.put(28, 343);
		  boardx.put(29, 415);
		  
		  boardy.put(0, 514);
		  boardy.put(1, 415);
		  boardy.put(2, 316);
		  boardy.put(3, 217);
		  boardy.put(4, 118);
		  boardy.put(5, 19);
		  
		  boardy.put(6, 19);
		  boardy.put(7, 19);
		  boardy.put(8, 19);
		  boardy.put(9, 19);
		  boardy.put(10, 19);
		  
		  boardy.put(11, 118);
		  boardy.put(12, 217);
		  boardy.put(13, 316);
		  boardy.put(14, 415);
		  boardy.put(15, 514);
		  
		  boardy.put(16, 514);
		  boardy.put(17, 514);
		  boardy.put(18, 514);
		  boardy.put(19, 514);
		  
		  boardy.put(20, 118);
		  boardy.put(21, 193);		  
		  boardy.put(22, 268);
		  boardy.put(23, 343);
		  boardy.put(24, 415);
		  boardy.put(25, 118);
		  boardy.put(26, 193);
		  boardy.put(27, 268);
		  boardy.put(28, 343);
		  boardy.put(29, 415);
	}
	
	public static void change()
	{
		setpos();
		
		//백도
		if(0 <= ThrowButton.randomYut && ThrowButton.randomYut <= 3)
		{
			if(i==0)
			{
				JOptionPane.showMessageDialog(null, "Player 1 is Win!");
				System.exit(0);
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=4;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 10)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=9;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=14;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i==20)
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=5;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i==22 || i==27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i-=1;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 28 || i == 23)
			{  			
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i==25)
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=10;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i-=1;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
		}		
		//도
		else if(4 <= ThrowButton.randomYut && ThrowButton.randomYut <= 14)
		{
			if(i == 0 || i==15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i+=1;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=20;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 10)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=25;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 26 || i==21)
			{  			
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 19)
			{
				JOptionPane.showMessageDialog(null, "Player 1 is Win!");
				System.exit(0);
			}
			else if(i==22 || i == 27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=28;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				change_p1();
				i+=1;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();			 
			}
		}
		//개
		else if(15 <= ThrowButton.randomYut && ThrowButton.randomYut <= 49)
		{
			if(i==0 || i==15)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i+=2;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=21;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			   
			}
			else if(i == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=26;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 19 || i== 18 || i == 28 || i == 29)
			{
				JOptionPane.showMessageDialog(null, "Player 1 is Win!");
				System.exit(0);
			}
			else if(i==22 || i==27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=29;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i==25 || i==20)
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				change_p1();
				i+=2;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
		}
		else if(50 <= ThrowButton.randomYut && ThrowButton.randomYut <= 84)
		{
			if(i==0 || i==15)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i+=3;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=22;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 19 || i == 18 || i == 17 || i == 29 || i == 28 || i == 27 || i==22)
			{
				JOptionPane.showMessageDialog(null, "Player 1 is Win!");
				System.exit(0);
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				change_p1();
				i+=3;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();			    
			}
		}
		//윷
		else if(85 <= ThrowButton.randomYut && ThrowButton.randomYut <= 97)
		{
			if(i == 0 || i==15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i+=4;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=23;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=28;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 19 || i == 18 || i == 17 || i == 16 || i == 29 || i == 28 || i == 27 || i == 26 || i == 22)
			{
				JOptionPane.showMessageDialog(null, "Player 1 is Win!");
				System.exit(0);
			}
			else if(i == 21)
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=15;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();				
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				change_p1();
				i+=4;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
		}
		//모
		else if(98 <= ThrowButton.randomYut && ThrowButton.randomYut <= 99)
		{
			if(i == 0)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i+=5;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=24;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=29;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else if(i == 19 || i == 18 || i == 17 || i == 16 || i == 15 || i == 29 || i == 28 || i == 27 || i == 26 || i == 25 || i==22) {
				JOptionPane.showMessageDialog(null, "P1, You win!");
				System.exit(0);
			}
			else if(i==20)
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				i=15;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
				Board.add(BoardCell[i]);
				BoardCell[i].repaint();
				
				s="YutBoard2_p1";
				change_p1();
				i+=5;
				Board.remove(BoardCell[i]);
				BoardCell[i] = new ViewPanel(i, setimage(i));
				BoardCell[i].setBounds(boardx.get(i),boardy.get(i) , 99, 99);
			    Board.add(BoardCell[i]);
			    BoardCell[i].repaint();
			    Board.repaint();
			}
		}
		breaken();
		Hunt();
	}
	public static void change2()
	{
		setpos();
		//백도
		if(0 <= ThrowButton.randomYut && ThrowButton.randomYut <= 3)
		{
			if(j==0)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=4;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=9;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=14;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==20)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=5;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==22 || j==27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j-=1;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 23 || j==28)
			{  			
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==28)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j-=1;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==25)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=10;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j-=1;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
		}
		//도
		else if(4 <= ThrowButton.randomYut && ThrowButton.randomYut <= 14)
		{
			if(j == 0 || j==15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j+=1;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=20;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=25;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 19)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else if(j==22 || j==27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=28;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==26 || j==21)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				change_p2();
				j+=1;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();			 
			}
		}
		//개
		else if(15 <= ThrowButton.randomYut && ThrowButton.randomYut <= 49)
		{
			if(j==0 || j==15)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j+=2;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=21;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=26;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 19 || j== 18 || j == 28 || j == 29)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else if(j==25 || j==20)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j==22 || j==27)
			{
				s="YutBoard1";
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=29;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				change_p2();
				j+=2;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
		}
		//걸
		else if(50 <= ThrowButton.randomYut && ThrowButton.randomYut <= 84)
		{
			if(j==0 || j==15)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j+=3;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=22;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=27;
				Board.remove(BoardCell[22]);
				Board.remove(BoardCell[27]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 19 || j == 18 || j == 17 || j == 29 || j == 28 || j == 27 || j==22)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				change_p2();
				j+=3;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();			    
			}
		}
		//윷
		else if(85 <= ThrowButton.randomYut && ThrowButton.randomYut <= 97)
		{
			if(j == 0 || j==15)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j+=4;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=23;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=28;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 19 || j == 18 || j == 17 || j == 16 || j == 29 || j == 28 || j == 27 || j == 26 || j == 22)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else if(j == 21)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=15;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();				
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				change_p2();
				j+=4;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
		}
		//모
		else if(98 <= ThrowButton.randomYut && ThrowButton.randomYut <= 99)
		{
			if(j == 0)
			{  			
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j+=5;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 5)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=24;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 10)
			{
				s="YutBoard1";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=29;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else if(j == 19 || j == 18 || j == 17 || j == 16 || j == 15 || j == 29 || j == 28 || j == 27 || j == 26 || j == 25 || j==22)
			{
				JOptionPane.showMessageDialog(null, "Player 2 is Win!");
				System.exit(0);
			}
			else if(j==20)
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				j=15;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
			else
			{
				s="YutBoard2";
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
				Board.add(BoardCell[j]);
				BoardCell[j].repaint();
				
				s="YutBoard2_p2";
				change_p2();
				j+=5;
				Board.remove(BoardCell[j]);
				BoardCell[j] = new ViewPanel(j, setimage(j));
				BoardCell[j].setBounds(boardx.get(j),boardy.get(j) , 99, 99);
			    Board.add(BoardCell[j]);
			    BoardCell[j].repaint();
			    Board.repaint();
			}
		}
		breaken();
		Hunt2();
	}
	
	//전체 패널인 Board에다가 윷놀이판 각각의 위치에 대응하는 panel을 넣어주는 메소드 
	public void BoardCellAdd()
	{
		int i = 0;
		for(i=0;i<27;i++) 	Board.add(BoardCell[i]);
		for(i=28;i<30;i++) 	Board.add(BoardCell[i]);
	}
	
	//각각의 위치에 대응하는 panel에 이미지를 삽입하는 메소드 
	public void setImg()
	{
		int i = 0;	
		for(i=0;i<30;i++)
		{
			if(i==0||i==5||i==10||i==15||i==27||i==22)
			{
				s="YutBoard1";
				BoardCell[i] = new ViewPanel(i ,setimage(i));
			}
			else
			{
				s="YutBoard2";
				BoardCell[i] = new ViewPanel(i, setimage(i));
			}
		}		
	}
	
	//처음 보드가 만들어질때 각각의 위치를 입력해주는 메소 
	public void setBound()
	{
		int posX = 514, posY = 514;
		int i=0;
		BoardCell[i].setBounds(posX, posY, 99, 99);
	    posY -= 99;
	    
		for (i = 1; i < 5; i++)
		{
		    BoardCell[i].setBounds(posX, posY, 99, 99);
		    posY -= 99;
		}
		
		i=5;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    posX = 415;
		
		for (i = 6; i < 10; i++)
		{
		    BoardCell[i].setBounds(posX, posY, 99, 99);
		    posX -= 99;
		}
		i=10;
		BoardCell[i].setBounds(posX, posY, 99, 99);
	    posY = 118;
	    
	    for (i = 11; i < 15; i++)
	    {
		    BoardCell[i].setBounds(posX, posY, 99, 99);
		    posY += 99;
	    }
	    i=15;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    posX = 118;
	    
	    for (i = 16; i < 20; i++)
	    {
		    BoardCell[i].setBounds(posX, posY, 99, 99);
		    posX += 99;
		}
	    i = 20;
	    posX = 415;
	    posY = 118;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 21;
	    posX -= 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 23;
	    posX -= 150;
	    posY += 150;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 24;
	    posX -= 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);	    
	   
	    posX = 118;
	    posY = 118;
	    
	    i = 25;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 26;
	    posX += 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	   
	    i = 22; //
	    posX += 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 27;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    
	    i = 28;
	    posX += 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	    	    
	    i = 29;
	    posX += 75;
	    posY += 75;
	    BoardCell[i].setBounds(posX, posY, 99, 99);
	}
	
	//p1이 특정위치에 올때 위치를 바꿔주는 메소드 
	public static void change_p1()
	{
		if(i==24) i-=10;
		else if(i==23)
			if(14<ThrowButton.randomYut &&ThrowButton.randomYut<=99) i-=10;
	}
	
	//p2가 특정위치에 올때 위치를 바꿔주는 메소
	public static void change_p2()
	{
		if(j==24) j-=10;
		else if(j==23)
			if(14<ThrowButton.randomYut &&ThrowButton.randomYut<=99) j-=10;
	}
	
	//말이 시작위치에 돌아왔을때 게임을 끝내는 메소드 
	public static void breaken()
	{
		if(i>=30)
		{
			JOptionPane.showMessageDialog(null, "Player 1 is Win!");
			System.exit(0);
		}
		if(j>=30)
		{
			JOptionPane.showMessageDialog(null, "Player 2 is Win!");
			System.exit(0);
		}
	}
	
	//p1말이 p2말을 잡았을 경우에 p2말을 시작위치로 보내는 메소드 
	public static void Hunt()
	{
		if(i==j) j=0;
	}
	
	//p2말이 p1말을 잡았을 경우에 p1말을 시작위치로 보내는 메소드 
	public static void Hunt2()
	{
		if(i==j) i=0;
	}
}