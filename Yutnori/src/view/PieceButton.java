package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;

public class PieceButton extends JButton implements ActionListener {
	private int x, y;
	
	public PieceButton(int x, int y) {
		this.x = x;
		this.y = y;
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {}
}
