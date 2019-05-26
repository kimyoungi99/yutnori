package model;

public class Yutnori {

	//private int turn = 0;
	//private int numOfPlayer; // turn: 0 ~ numOfPlayer-1
	private Board board;
	private Yut[] yutSet = new Yut[4];

	public Yutnori() {
		for (int i = 0; i < 4; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}
		this.board = new Board();
	}

	/*
	public int getTurn() {
		return turn;
	}

	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	*/

	public Yut[] getYutSet() {
		return yutSet;
	}

	public void move(int selectedPiece, int x, int y) {

	}
}