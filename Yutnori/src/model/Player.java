package model;

import java.util.Vector;

public class Player {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = 4;
	private int numOfRestTurn;

	public Player(int playerID) {
		this.playerID = playerID;
	}

	public void setNumOfRestPiece(int numOfPassPiece) {
		this.numOfRestPiece -= numOfPassPiece;
	}

	public Vector<Integer> throwYut() {
		int numOfFront = 0;
		boolean[] throwResult = new boolean[4];
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
			if (numOfFront == 1 && throwResult[3]) {
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
		//Tile selectTile = yutnori.getBoard().boardTable[select.getX()][select.getY()];
		//Tile targetTile = yutnori.getBoard().boardTable[target.getX()][target.getY()];
		
		//새 말로 출발할 경우 selectTile의 piece가 yutnori.getBoard().waitingPiece[0].getTopPiece()
		//근데 메소드 내에서 설정하는 것 보다는 애초에 함수 파라미터로 설정해서 넘겨주는게 좋을듯(일단 임시) 
		if(isStart) {
			selectTile.putPiece(yutnori.getBoard().waitingPiece[0].getTopPiece());
		}
		
		boolean isCatch = false;
		if (targetTile.getPiece() == null) {
			targetTile.putPiece(selectTile.getPiece());
		} else if (targetTile.getPiece().getTeam() == selectTile.getPiece().getTeam()) {
			targetTile.getTopPiece().stackPiece(selectTile.getPiece());
		} else {
			targetTile.putPiece(selectTile.getPiece());
			yutnori.getBoard().waitingPiece[0].getTopPiece().stackPiece(targetTile.getPiece());
			isCatch = true;
			// 윷 던지기 횟수 1회 추가 필요
		}
		selectTile.removePiece();
		return isCatch;
	}
}

