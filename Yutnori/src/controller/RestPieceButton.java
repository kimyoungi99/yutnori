package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Piece;
import model.Tile;

public class RestPieceButton extends JButton implements ActionListener {
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
		// model.getTurnPlayer().decreaseNumOfRestPiece();
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		pieceList = restPieceBoard[x][y].getPieceList();
		if (model.getStatus() == 1) {
			if (pieceList.isEmpty() || pieceList.get(0).getTeam() != model.getTurn()) {
				//model.setSelectX(0);
				//model.setSelectY(0);
				model.getTurnPlayer().clearCanGoCordVector();
				model.getTurnPlayer().cancelHighlight();
			} else {
				model.setStatus(2);
				model.setSelectX(x);
				model.setSelectY(y);
				model.getTurnPlayer().getCanGoTile(restPieceBoard[x][y]);
				//하이라이트 취소
			}
		} 
	}
}
