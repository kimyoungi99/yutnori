package model;

public class Board {
    public Tile[][] boardTable = new Tile[6][5];


    Board() {
    		
    }
    
    public int get_num_of_piece(Cord selected) {
    	int num = 0;
    	Piece ptr = boardTable[selected.x][selected.y].get_piece();
    	if(ptr == null) 
    		return num;
    	while(ptr != null) {
    		num++;
    		ptr = ptr.get_nextPiece();
    	}
    	return num;
    }
}
