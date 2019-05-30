package model;

public class Board {
	public Tile[][] gameBoard = new Tile[6][5];
	public Tile[] waitingPieceBoard = new Tile[CONSTANT.PLAYERNUM];

	public Board(Piece[][] pieceArray) {
		for (int i = 0; i < waitingPieceBoard.length; i++) {
			for (int j = CONSTANT.PIECENUM - 1; j > 0; j--) {
				pieceArray[i][j].stackPiece(pieceArray[i][j - 1]);
			}
			waitingPieceBoard[i].putPiece(pieceArray[i][3]);
		}
	}
}
