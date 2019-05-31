package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.Model;

public class ThrowButton extends JButton implements ActionListener {
	
	private int numOfPlayer;
	private Model model;
	
	ThrowButton(String text, Model model) {
		setText(text);
		addActionListener(this);
		this.model = model;
	}
	
	public void initGame(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer(this.numOfPlayer).throwYut();
	}
}
