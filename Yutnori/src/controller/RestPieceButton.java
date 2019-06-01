package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;

public class RestPieceButton extends JButton implements ActionListener{
	private int posI;
	private int posJ;
	private Model model;
	
	public RestPieceButton(int i, int j, Model model) {
		this.posI = i;
		this.posJ = j;
		this.model = model;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 제대로 구현 해야됨
		System.out.println("asdf");
		model.getTurnPlayer().decreaseNumOfRestPiece();
	}
}
