package model;

public class Board {
    public Tile[][] boardTable = new Tile[6][5];
    public Tile[] waitingPiece = new Tile[4];
    
    public int getNumOfPiece(Cord selected) {
    	int num = 0;
    	Piece ptr = boardTable[selected.getX()][selected.getY()].getPiece();
    	if(ptr == null) 
    		return num;
    	while(ptr != null) {
    		num++;
    		ptr = ptr.getNextPiece();
    	}
    	return num;
    }
}
