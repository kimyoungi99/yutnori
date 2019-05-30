package model;

public class Tile {
	private Piece piece;
	
	Tile(Piece piece) {
		this.piece = piece;
	}
	
	public void putPiece(Piece piece) {
		this.piece = piece;
	}

	public void removePiece() {
		this.piece = null;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public Piece getTopPiece() {
		if(this.piece == null || this.piece.getNextPiece() == null)
			return this.piece;
		else {
			Piece ptr = this.piece;
			while(ptr.getNextPiece() == null)
				ptr = ptr.getNextPiece();
			return ptr;
		}
	}
}
