package model;

public class Yutnori {
	
	private int turn;
	private Board board;
	private int numOfPlayer;
	private Yut[] yutSet = new Yut[4];
	
	public Yutnori() {
		for(int i = 0; i < 4; i++) {
			yutSet[i] = new Yut(i);		// if i == 3 then BACKDO
		}
		board = new Board();
	}
	
	public void setGame(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
		
	}
	
	public void move(int selectedPiece, int x, int y) {
		
	}
}