package model;

public class Piece {
	private int id;
	private int team;
	private Piece nextPiece;
	
	Piece(int id, int team) {
		this.id = id;
		this.team = team;
		this.nextPiece = null;
	}
	
	public int get_id() {
		return id;
	}
	
	public void stack_piece(Piece p) {
		this.nextPiece = p;
	}
	
	public void detach_piece() {
		this.nextPiece = null;
	}
}
