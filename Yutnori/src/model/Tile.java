package model;

import java.util.ArrayList;

public class Tile {
	int x, y;
	private ArrayList<Piece> pieceList = new ArrayList<Piece>();
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void putPiece(ArrayList<Piece> pieceList) {
		this.pieceList.addAll(pieceList);
	}
	
	public void removePiece() {
		this.pieceList.clear();
	}
	
	public ArrayList<Piece> getPieceList(){
		return pieceList;
	}
}
