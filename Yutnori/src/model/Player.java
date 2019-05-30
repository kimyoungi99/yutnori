package model;

import java.util.Vector;

public class Player {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = CONSTANT.PIECENUM;
	private int numOfRestTurn;

	public Player(int playerID) {
		this.playerID = playerID;
	}

	public void setNumOfRestPiece(int numOfPassPiece) {
		this.numOfRestPiece -= numOfPassPiece;
	}
	
	public int getNumOfRestPiece() {
		return numOfRestPiece;
	}

	public Vector<Integer> throwYut() {
		int numOfFront = 0;
		boolean[] throwResult = new boolean[CONSTANT.YUTNUM];
		Vector<Integer> numOfFrontVector = new Vector<Integer>();
		numOfRestTurn = 1;
		while (numOfRestTurn > 0) {
			numOfFront = 0;
			for (int i = 0; i < yutnori.getYutSet().length; i++) {
				if (throwResult[i] = yutnori.getYutSet()[i].getIsFront()) {
					numOfFront++;
				}
			}
			// 백도
			if (numOfFront == 1 && throwResult[CONSTANT.YUTNUM - 1]) {
				numOfFront = -1;
			}

			else if (numOfFront == 0 || numOfFront == 4) {
				numOfRestTurn++;
				if (numOfFront == 0) {
					numOfFront = 5;
				}
			}
			numOfFrontVector.add(numOfFront);
			numOfRestTurn--;
		}
		return numOfFrontVector;
	}
	
	public boolean movePiece(Tile selectTile, Tile targetTile, boolean isStart) {
	//public boolean movePiece(Cord select, Cord target) {
		//Tile selectTile = yutnori.getBoard().gameBoard[select.getX()][select.getY()];
		//Tile targetTile = yutnori.getBoard().gameBoard[target.getX()][target.getY()];
		
		//새 말로 출발할 경우 selectTile의 piece가 yutnori.getBoard().waitingPiece[playerID].getTopPiece()
		if(isStart) {
			targetTile.putPiece(selectTile.getTopPiece());
		}
		
		boolean isCatch = false;
		if (targetTile.getPiece() == null) {
			targetTile.putPiece(selectTile.getPiece());
		} else if (targetTile.getPiece().getTeam() == selectTile.getPiece().getTeam()) {
			targetTile.getTopPiece().stackPiece(selectTile.getPiece());
		} else {
			targetTile.putPiece(selectTile.getPiece());
			yutnori.getBoard().getWaitingPieceBoard()[playerID].getTopPiece().stackPiece(targetTile.getPiece());
			isCatch = true;
			// 윷 던지기 횟수 1회 추가 필요
		}
		
		if(isStart) {
			//selectTile의 TopPiece만 제거
		} 
		else {
			selectTile.removePiece();
		}
		return isCatch;
	}
}

