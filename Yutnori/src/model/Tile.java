package model;

public class Tile {
	private Piece piece;
	
	Tile(Piece piece) {
		this.piece = piece;
	}
	
	public void put_piece(Piece piece) {
		this.piece = piece;
	}

	public void remove_piece() {
		this.piece = null;
	}
	
	public Piece get_piece() {
		return this.piece;
	}
	
	public Piece get_top_piece() {
		if(this.piece == null || this.piece.get_nextPiece() == null)
			return this.piece;
		else {
			Piece ptr = this.piece;
			while(ptr.get_nextPiece() == null)
				ptr = ptr.get_nextPiece();
			return ptr;
		}
	}
	
}
