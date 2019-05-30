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
	
	public int getTeam() {
		return team;
	}
	
	public Piece getNextPiece() {
		return this.nextPiece;
	}
	
	public void stackPiece(Piece piece) {
		this.nextPiece = piece;
	}
	
	public void detachPiece() {
		this.nextPiece = null;
	}
}
