package model;

public class Yutnori {

	private int turn = 0;
	private int numOfPlayer;
	private Piece[][] pieceArray = new Piece[4][4];
	private Yut[] yutSet = new Yut[4];
	private Board board;

	public Yutnori() {
		for (int i = 0; i < 4; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}
		this.board = new Board();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.pieceArray[i][j] = new Piece(i * 10 + j, i);
			}
		}
	}

	public int getTurn() {
		return turn;
	}

	public Yut[] getYutSet() {
		return yutSet;
	}

	public Board getBoard() {
		return board;
	}
	
	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
}