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
	
	public int getID() {
		return id;
	}
	
	public void stackPiece(Piece p) {
		this.nextPiece = p;
	}
	
	public void detachPiece() {
		this.nextPiece = null;
	}
	
	public Piece getNextPiece() {
		return this.nextPiece;
	}
	
	public int getTeam() {
		return team;
	}
}
