package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Piece;
import model.Tile;

public class TileButton extends PieceButton{
	int x, y;

	public TileButton(Model model, int x, int y) {
		super(model);
		this.x = x;
		this.y = y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		boolean isMove = false;
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		Tile selectTile = new Tile(0, 0);
		Tile targetTile = new Tile(0, 0);
		gameBoard = model.getTurnPlayer().getYutnori().getBoard().getGameBoard();
		restPieceBoard = model.getTurnPlayer().getYutnori().getBoard().getWaitingPieceBoard();
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		pieceList = gameBoard[x][y].getPieceList();
		
		
		if (model.getTurnPlayer().getClickData().getStatus() == 1) {
			/*
			if (pieceList.isEmpty()) {

			} else if (pieceList.get(0).getTeam() != model.getTurn()) {

			} else {
				model.getTurnPlayer().getClickData().setClickData(3, x, y);
				*/
				
				model.getTurnPlayer().getCanGoTile(x, y, 1);
			//}
		} else if (model.getTurnPlayer().getClickData().getStatus() > 1) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == x && cord.getY() == y) {
					isMove = true;
					targetTile = gameBoard[x][y];
					if (model.getTurnPlayer().getClickData().getStatus() == 2)
						selectTile = restPieceBoard[model.getTurnPlayer().getClickData().getSelectedX()][model.getTurnPlayer().getClickData().getSelectedY()];
					if (model.getTurnPlayer().getClickData().getStatus() == 3)
						selectTile = gameBoard[model.getTurnPlayer().getClickData().getSelectedX()][model.getTurnPlayer().getClickData().getSelectedY()];
					model.getTurnPlayer().movePiece(selectTile, targetTile);
				}
			}
			if (isMove) {
				model.getTurnPlayer().deleteDistance(selectTile, targetTile);
				model.getTurnPlayer().getClickData().setStatus(1);
				model.turnCheck();
				
			} /*else if (!pieceList.isEmpty() && pieceList.get(0).getTeam() == model.getTurn()) {
				model.getTurnPlayer().getClickData().setClickData(3, x, y);
				model.getTurnPlayer().cancelHighlight();
				model.getTurnPlayer().getCanGoTile(gameBoard[x][y]);
			} 
			*/
			else if (pieceList.isEmpty() || pieceList.get(0).getTeam() != model.getTurn()) {
				model.getTurnPlayer().getClickData().setStatus(1);
				model.getTurnPlayer().cancelHighlight();
			}
			else {
				model.getTurnPlayer().getCanGoTile(x, y, 1);
			}
		}
	}
}
