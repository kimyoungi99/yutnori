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

public class RestPieceButton extends PieceButton {
	private int x, y;

	public RestPieceButton(int x, int y, Model model) {
		super(model);
		this.x = x;
		this.y = y;
	}

	public void actionPerformed(ActionEvent e) {
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		pieceList = restPieceBoard[x][y].getPieceList();
		if (model.getClickData().getStatus() != 0) {
			if (pieceList.isEmpty() || pieceList.get(0).getTeam() != model.getTurn()) {
				model.getTurnPlayer().cancelHighlight();
			} else {
				model.getClickData().setClickData(2, x, y);
				model.getTurnPlayer().cancelHighlight();
				model.getTurnPlayer().getCanGoTile(restPieceBoard[x][y]);
			}
		} 
	}
}
