package model;

import java.util.ArrayList;

public class Board {
	private Tile[][] gameBoard = new Tile[6][5];
	private Tile[] waitingPieceBoard = new Tile[CONSTANT.PLAYERNUM];

	public Board(Piece[][] pieceArray) {
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard[0].length; j++) {
				gameBoard[i][j] = new Tile();
			}
		}

		for(int i=0; i<waitingPieceBoard.length; i++) {
			waitingPieceBoard[i] = new Tile();
			for(int j=0; j<CONSTANT.PIECENUM; j++) {
				pieceList.add(pieceArray[i][j]);
			}
			waitingPieceBoard[i].putPiece(pieceList);
			pieceList.clear();
		}
	}

	public Tile[][] getGameBoard() {
		return gameBoard;
	}

	public Tile[] getWaitingPieceBoard() {
		return waitingPieceBoard;
	}
}
