package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Piece;
import model.Tile;

public class RestPieceButton extends JButton implements ActionListener{
	private int x, y;
	private Model model;
	private Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
	
	public RestPieceButton(int x, int y, Model model) {
		this.x = x;
		this.y = y;
		this.model = model;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Vector<Cord> cordVector = new Vector<Cord> ();
		//model.getTurnPlayer().decreaseNumOfRestPiece();
		int status = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		pieceList = restPieceBoard[x][y].getPieceList();
		if(pieceList.isEmpty()) {

		}
		else if(pieceList.get(0).getTeam() != model.getTurn()) {

		}
		else{
			status = 1;
			cordVector = model.getTurnPlayer().getCanGoTile(restPieceBoard[x][y]);
		}
	}
}
