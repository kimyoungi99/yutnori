package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import model.Tile;

public class TileButton extends JButton implements ActionListener {
	private Model model;
	
	public TileButton(Model model) {
		this.model = model;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Tile[][] gameBoard = new Tile[6][5];
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
	}
}
