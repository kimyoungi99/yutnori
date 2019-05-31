package model;

import java.util.Iterator;
import java.util.Vector;

public class Player {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = CONSTANT.PIECENUM;

	public Player(int playerID) {
		this.playerID = playerID;
	}

	public void setNumOfRestPiece(int numOfPassPiece) {
		this.numOfRestPiece -= numOfPassPiece;
	}

	public int getNumOfRestPiece() {
		return numOfRestPiece;
	}

	public int throwYut() {
		int numOfFront = 0;
		boolean[] throwResult = new boolean[CONSTANT.YUTNUM];
		Vector<Integer> numOfFrontVector = new Vector<Integer>();
		numOfFront = 0;
		for (int i = 0; i < yutnori.getYutSet().length; i++) {
			if (throwResult[i] = yutnori.getYutSet()[i].getIsFront()) {
				numOfFront++;
			}
		}
		// 백도
		if (numOfFront == 1 && throwResult[CONSTANT.YUTNUM - 1])
			numOfFront = -1;
		return numOfFront;
	}

	public boolean movePiece(Tile selectTile, Tile targetTile, boolean isStart) {
		// public boolean movePiece(Cord select, Cord target) {
		// Tile selectTile = yutnori.getBoard().gameBoard[select.getX()][select.getY()];
		// Tile targetTile = yutnori.getBoard().gameBoard[target.getX()][target.getY()];

		// 새 말로 출발할 경우 selectTile의 piece가
		// yutnori.getBoard().waitingPiece[playerID].getTopPiece()
		if (isStart) {
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
		}

		if (isStart) {
			// selectTile의 TopPiece만 제거
		} else {
			selectTile.removePiece();
		}
		return isCatch;
	}

	public Vector<Vector<Cord>> getCanGoTile(Vector<Integer> result) {
		int distance;
		Vector<Vector<Cord>> canGoCordVectorforEveryDistance = new Vector<Vector<Cord>>();
		Iterator<Integer> distanceIterator = result.iterator();
		Tile[][] gameBoard = yutnori.getBoard().getGameBoard();
		Cord currentCord = new Cord();
		Cord canGoCord = new Cord();
		boolean isStart = false;
		
		while(distanceIterator.hasNext()) {
			distance = distanceIterator.next();
			Vector<Cord> canGoCordVector = new Vector<Cord>();
			for(int j=0; j<6; j++) {
				for(int k=0; k<5; j++) {
					if(gameBoard[j][k].getPiece() != null && gameBoard[j][k].getPiece().getTeam() == playerID) {
						currentCord.setCord(j, k);
						currentCord.transform(distance, isStart);
						canGoCord.setCord(currentCord.getX(), currentCord.getY());
						canGoCordVector.add(canGoCord);
					}
				}
			}
			canGoCordVectorforEveryDistance.add(canGoCordVector);
		}
		return canGoCordVectorforEveryDistance;
	}
}
