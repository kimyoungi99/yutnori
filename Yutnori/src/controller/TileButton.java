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
		/*
		 * int status = 0; ArrayList<Piece> pieceList = new ArrayList<Piece>();
		 * gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		 * pieceList = gameBoard[x][y].getPieceList(); if(pieceList.isEmpty()) {
		 * 
		 * } else if(pieceList.get(0).getTeam() != model.getTurn()) {
		 * 
		 * } else{ status = 1; }
		 */
		//Vector<Cord> cordVector = new Vector<Cord>();
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		pieceList = gameBoard[x][y].getPieceList();
		if (model.getStatus() == 0) {
			if (pieceList.isEmpty()) {

			} else if (pieceList.get(0).getTeam() != model.getTurn()) {

			} else {
				model.setStatus(1);
				model.setSelectX(x);
				model.setSelectY(y);
				model.getTurnPlayer().getCanGoTile(gameBoard[x][y]);
			}
		} else if (model.getStatus() == 1 || model.getStatus() == 2) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == x && cord.getY() == y) {
					System.out.println("Move OK");
					if(model.getStatus() == 1)
						model.getTurnPlayer().movePiece(gameBoard[model.getSelectX()][model.getSelectY()], gameBoard[x][y]);
					if(model.getStatus() == 2)
						model.getTurnPlayer().movePiece(restPieceBoard[model.getSelectX()][model.getSelectY()], gameBoard[x][y]);
					//canGoCordVector에서 움직인 칸(x, y) 제외, 새로 하이라이트
				}
				else if(!pieceList.isEmpty() && pieceList.get(0).getTeam() == model.getTurn()) {
					model.setSelectX(x);
					model.setSelectY(y);
					model.getTurnPlayer().clearCanGoCordVector();
					model.getTurnPlayer().getCanGoTile(gameBoard[x][y]);
				}
				else {
					model.setStatus(0);
					model.setSelectX(0);
					model.setSelectY(0);
					model.getTurnPlayer().clearCanGoCordVector();
					//하이라이트 취소
				}
			}
		}
	}
}
