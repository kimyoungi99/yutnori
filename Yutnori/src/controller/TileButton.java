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
		boolean isMove = false;
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		int catchNum = 0;
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		Cord beforeCord = new Cord();
		Cord afterCord = new Cord();
		int tempX = 0, tempY = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		pieceList = gameBoard[x][y].getPieceList();
		if (model.getStatus() == 1) {
			if (pieceList.isEmpty()) {

			} else if (pieceList.get(0).getTeam() != model.getTurn()) {

			} else {
				model.setStatus(3);
				model.setSelectX(x);
				model.setSelectY(y);
				model.getTurnPlayer().getCanGoTile(gameBoard[x][y]);
			}
		} else if (model.getStatus() == 2 || model.getStatus() == 3) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == x && cord.getY() == y) {
					// deleteX = x;
					// deleteY = y;
					isMove = true;
					if (model.getStatus() == 2) {
						catchNum = model.getTurnPlayer().movePiece(restPieceBoard[model.getSelectX()][model.getSelectY()],
								gameBoard[x][y]);
						tempX = 0;
						tempY = 0;
					}
					if (model.getStatus() == 3) {
						catchNum = model.getTurnPlayer().movePiece(gameBoard[model.getSelectX()][model.getSelectY()],
								gameBoard[x][y]);
						tempX = model.getSelectX();
						tempY = model.getSelectY();
					// canGoCordVector에서 움직인 칸(x, y) 제외, 새로 하이라이트
					}
				}
			}
			if (isMove) {
				int distance;
				beforeCord.setCord(tempX, tempY);
				afterCord.setCord(x, y);
				distance = afterCord.distance(beforeCord);
				model.getTurnPlayer().deleteDistance(distance);
				model.setStatus(1);
				model.getTurnPlayer().getCanGoCordVector().clear();
				if(catchNum > 0) {
					model.getTurnPlayer().addNumOfThrowChance();
				}
				if(model.getTurnPlayer().getNumOfThrowChance() == 0 && model.getTurnPlayer().getthrowYutResultVector().isEmpty()) {
					model.nextTurn();
				}
			} else if (!pieceList.isEmpty() && pieceList.get(0).getTeam() == model.getTurn()) {
				model.setStatus(3);
				model.setSelectX(x);
				model.setSelectY(y);
				model.getTurnPlayer().clearCanGoCordVector();
				model.getTurnPlayer().cancelHighlight();
				model.getTurnPlayer().getCanGoTile(gameBoard[x][y]);
			} 
			else if (pieceList.isEmpty() || pieceList.get(0).getTeam() != model.getTurn()) {
				model.setStatus(1);
				model.getTurnPlayer().clearCanGoCordVector();
				model.getTurnPlayer().cancelHighlight();
			}
		}
	}
}
