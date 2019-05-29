package model;

public class Yutnori {
	
	private int turn;
	private int numOfPlayer;
	private Board board;
	private Piece[][] pieceArray = new Piece[4][4];
	private Yut[] yutSet = new Yut[4];

	public Yutnori() {
		for (int i = 0; i < 4; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}
		this.board = new Board();
		
		for (int i =0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				this.pieceArray[i][j] = new Piece(i * 10 + j, i);
	}

	public int getTurn() {
		return turn;
	}
	
	public Yut[] getYutSet() {
		return yutSet;
	}

	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public boolean move(Cord selected, Cord target) {
		boolean catched = false;
		if(this.board.boardTable[target.getX()][target.getY()].get_piece() == null) {
	    	this.board.boardTable[target.getX()][target.getY()].put_piece(this.board.boardTable[selected.getX()][selected.getY()].get_piece());
			this.board.boardTable[selected.getX()][selected.getY()].remove_piece();
		}
		else if(this.board.boardTable[target.getX()][target.getY()].get_piece().get_team() == this.board.boardTable[selected.getX()][selected.getY()].get_piece().get_team()) {
			this.board.boardTable[target.getX()][target.getY()].get_top_piece().stack_piece(board.boardTable[selected.getX()][selected.getY()].get_piece());
			this.board.boardTable[selected.getX()][selected.getY()].remove_piece();
		}
		else {
			this.board.boardTable[target.getX()][target.getY()].put_piece(this.board.boardTable[selected.getX()][selected.getY()].get_piece());
			catched = true;
		}
		return catched;
	}
}