package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Model;

public class ThrowButton extends JButton implements ActionListener {
	
	private int throwButtonID;
	private Model model;
	
	private ImageIcon backDoeImage = new ImageIcon("src/view/image/BackDoe.jpg");
	private ImageIcon daoImage = new ImageIcon("src/view/image/Dao.jpg");
	private ImageIcon gaeImage = new ImageIcon("src/view/image/Gae.jpg");
	private ImageIcon gurlImage = new ImageIcon("src/view/image/Gurl.jpg");
	private ImageIcon yutImage = new ImageIcon("src/view/image/Yut.jpg");
	private ImageIcon moeImage = new ImageIcon("src/view/image/Moe.jpg");
	
	ThrowButton(Model model, String text) {
		this.model = model;
		setText(text);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int throwResult;
		throwResult = model.getTurnPlayer().throwYut();
	}
}
