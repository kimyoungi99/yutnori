package model;

public class Piece {
	private int id;
	private int team;
	
	public Piece(int id, int team) {
		this.id = id;
		this.team = team;
	}
	
	public int getID() {
		return id;
	}
	
	public int getTeam() {
		return team;
	}
	
	/*
	public Piece getNextPiece() {
		return this.nextPiece;
	}
	
	public void stackPiece(Piece piece) {
		this.nextPiece = piece;
	}
	
	public void detachPiece() {
		this.nextPiece = null;
	}
	*/
}
