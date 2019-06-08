package model;

public class Yutnori {

	private Piece[][] pieceArray = new Piece[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
	private Yut[] yutSet = new Yut[CONSTANT.YUTNUM];
	private Board board;

	public Yutnori() {
		for (int i = 0; i < yutSet.length; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}

		for (int i = 0; i < pieceArray.length; i++) {
			for (int j = 0; j < pieceArray[0].length; j++) {
				this.pieceArray[i][j] = new Piece(j, i);
			}
		}

		this.board = new Board(pieceArray);
	}

	public Yut[] getYutSet() {
		return yutSet;
	}

	public Board getBoard() {
		return board;
	}

	public Piece[][] getPieceArray() {
		return pieceArray;
	}
	
	public void reset() {
		for (int i = 0; i < yutSet.length; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}

		for (int i = 0; i < CONSTANT.PLAYERNUM; i++) {
			for (int j = 0; j < CONSTANT.PIECENUM; j++) {
				this.pieceArray[i][j] = new Piece(j, i);
			}
		}
		board = new Board(pieceArray);
	}
}