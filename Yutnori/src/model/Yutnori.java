package model;

public class Yutnori {
	
	private int turn;
	private int numOfPlayer;
	private Board board;
	private Yut[] yutSet = new Yut[4];

	public Yutnori() {
		for (int i = 0; i < 4; i++) {
			this.yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}
		this.board = new Board();
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
		if(this.board.boardTable[target.x][target.y].get_piece() == null) {
	    	this.board.boardTable[target.x][target.y].put_piece(this.board.boardTable[selected.x][selected.y].get_piece());
			this.board.boardTable[selected.x][selected.y].remove_piece();
		}
		else if(this.board.boardTable[target.x][target.y].get_piece().get_team() == this.board.boardTable[selected.x][selected.y].get_piece().get_team()) {
			this.board.boardTable[target.x][target.y].get_top_piece().stack_piece(board.boardTable[selected.x][selected.y].get_piece());
			this.board.boardTable[selected.x][selected.y].remove_piece();
		}
		else {
			this.board.boardTable[target.x][target.y].put_piece(this.board.boardTable[selected.x][selected.y].get_piece()); // 다시 Piece 원상복귀 시키는 거 구현해야됨
			catched = true;
		}
		return catched;
	}
}