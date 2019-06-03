package model;

import java.util.ArrayList;

public class Board {
	private Tile[][] gameBoard = new Tile[6][5];
	private Tile[][] waitingPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];

	public Board(Piece[][] pieceArray) {
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard[0].length; j++) {
				gameBoard[i][j] = new Tile(i, j);
			}
		}
		
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		for(int i=0; i<waitingPieceBoard.length; i++) {
			for(int j=0; j<waitingPieceBoard[0].length; j++) {
				waitingPieceBoard[i][j] = new Tile(0, 0);
				pieceList.add(pieceArray[i][j]);
				waitingPieceBoard[i][j].putPiece(pieceList);
			}
			pieceList.clear();
		}
	}

	public Tile[][] getGameBoard() {
		return gameBoard;
	}

	public Tile[][] getWaitingPieceBoard() {
		return waitingPieceBoard;
	}
}
