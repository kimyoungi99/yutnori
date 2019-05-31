package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Model;

public class ThrowButton extends JButton implements ActionListener {
	
	private int numOfPlayer;
	private Model model;
	
	private ImageIcon daoImage = new ImageIcon("src/image/Dao.jpg");
	private ImageIcon gaeImage = new ImageIcon("src/image/Gae.jpg");
	private ImageIcon gurlImage = new ImageIcon("src/image/Gurl.jpg");
	private ImageIcon yutImage = new ImageIcon("src/image/Yut.jpg");
	private ImageIcon moeImage = new ImageIcon("src/image/Moe.jpg");
	
	ThrowButton(String text, Model model) {
		setText(text);
		addActionListener(this);
		this.model = model;
	}
	
	public void initGame(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public void actionPerformed(ActionEvent e) {
		int throwRes;
		throwRes = model.getTurnPlayer(this.numOfPlayer).throwYut();
		switch(throwRes) {
		case -1:
			
		}
	}
}
