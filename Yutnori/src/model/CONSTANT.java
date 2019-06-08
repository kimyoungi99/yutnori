package model;

public class CONSTANT {
	  public static int PIECENUM = 5;
	  public static final int YUTNUM = 4;
	  public static int PLAYERNUM = 4;
	  
	  public CONSTANT(int playerNum, int pieceNum) {
		  this.PIECENUM = pieceNum;
		  this.PLAYERNUM = playerNum;
	  }
	  
	  public void setPIECENUM(int pieceNum) {
		  PIECENUM = pieceNum;
	  }
	  
	  public void setPLAYERNUM(int playerNum) {
		  PLAYERNUM = playerNum;
	  }
}
