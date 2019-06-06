package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;

public class GameBoardButton extends JButton implements ActionListener {
	protected Model model;
	
	public GameBoardButton(Model model) {
		this.model = model;
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {}
}
