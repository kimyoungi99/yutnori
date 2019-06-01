package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import model.Model;
import model.Piece;
import model.Tile;

public class TileButton extends JButton implements ActionListener {
	private Model model;
	int x, y;
	private Tile[][] gameBoard = new Tile[6][5];
	
	public TileButton(Model model, int x, int y) {
		this.model = model;
		this.x = x;
		this.y = y;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int status = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		pieceList = gameBoard[x][y].getPieceList();
		if(pieceList.isEmpty()) {
			
		}
		else if(pieceList.get(0).getTeam() != model.getTurn()) {
			
		}
		else{
			status = 1;
		}
	}
}
