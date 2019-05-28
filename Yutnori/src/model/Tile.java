package model;

public class Tile {
	private Piece piece;
	
	Tile(Piece piece) {
		this.piece = piece;
	}
	
	public void put_piece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece get_piece() {
		return piece;
	}
}
