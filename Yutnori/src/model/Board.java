package model;

public class Board {
    public Tile[][] boardTable = new Tile[6][5];


    Board() {
    		
    }
    
    public int get_num_of_piece(int selected_x, int selected_y) {
    	int num = 0;
    	if(boardTable[selected_x][selected_y].get_piece() == null) 
    		return num;
    	Piece ptr = boardTable[selected_x][selected_y].get_piece();
    	while(ptr != null) {
    		num++;
    		ptr = ptr.get_nextPiece();
    	}
    	num++;
    	return num;
    }
}
