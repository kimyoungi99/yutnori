package model;

public class Yutnori {
	
	private int turn;
	private Board board = new Board();
	private int numOfPlayer;
	private Yut[] yutSet = new Yut[4];
	
	public Yutnori() {
		for(int i = 0; i < 4; i++) {
			yutSet[i] = new Yut(i); // if i == 3 then BACKDO
		}
	}
	
	public void setGame(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
		
	}
	
	public boolean move(int selected_x, int selected_y, int target_x, int target_y) {
		boolean catched = false;
		if(this.board.boardTable[target_x][target_y].get_piece() == null) {
	    	this.board.boardTable[target_x][target_y].put_piece(this.board.boardTable[selected_x][selected_y].get_piece());
			this.board.boardTable[selected_x][selected_y].remove_piece();
			catched = true;
		}
		else if(this.board.boardTable[target_x][target_y].get_piece().get_team() == this.board.boardTable[selected_x][selected_y].get_piece().get_team()) {
			
		}
		else {
			
		}
		
		return catched;
	}
}