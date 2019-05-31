package model;

import java.util.ArrayList;

public class Tile {
	private ArrayList<Piece> pieceList = new ArrayList<Piece>();
		
	public void putPiece(ArrayList<Piece> pieceList) {
		this.pieceList.addAll(pieceList);
	}
	
	public void removePiece() {
		this.pieceList.clear();
	}
	
	public ArrayList<Piece> getPieceList(){
		return pieceList;
	}
	
	/*
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
	
    public int getNumOfPiece() {
    	int num = 0;
    	//Piece ptr = boardTable[selected.getX()][selected.getY()].getPiece();
    	if(piece == null) 
    		return num;
    	while(piece != null) {
    		num++;
    		piece = piece.getNextPiece();
    	}
    	return num;
    }
    */
}
