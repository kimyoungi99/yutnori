package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import view.Observer;

public class Player implements Observable {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfThrowChance = 0;
	private int numOfRestPiece = CONSTANT.PIECENUM;
	private int numOfPassPiece = 0;
	private Vector<Integer> throwYutResultVector = new Vector<Integer>();
	private Vector<Cord> canGoCordVector = new Vector<Cord>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public Player(int playerID) {
		this.playerID = playerID;
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyYutResultObserver(int result) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateYutResultPanel(result);
		}
	}

	@Override
	public void notifyHighlightObserver(Vector<Cord> highlightCord) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateHighlightCanGoTile(highlightCord);
		}
	}

	@Override
	public void notifyBoardObserver(Board board) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateBoard(board);
		}
	}
	
	@Override
	public void notifyThrowChanceObserver(int chance) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateThrowChanceLabel(chance);
		}
	}
	
	@Override
	public void notifyTurnObserver(int turn) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateTurnLabel(turn);
		}
	}

	public void setNumOfPassPiece(int numOfPassPiece) {
		this.numOfPassPiece += numOfPassPiece;
	}

	public int getNumOfRestPiece() {
		return numOfRestPiece;
	}

	public int getPlayerId() {
		return playerID;
	}

	public Vector<Integer> getthrowYutResultVector() {
		return throwYutResultVector;
	}
	
	public Vector<Cord> getCanGoCordVector() {
		return canGoCordVector;
	}
	
	
	public void addNumOfThrowChance() {
		numOfThrowChance ++;
		notifyTurnObserver(playerID);
	}
	
	
	public void subNumOfThrowChance() {
		numOfThrowChance --;
	}
	
	public int getNumOfThrowChance() {
		return numOfThrowChance;
	}

	public void clearCanGoCordVector() {
		canGoCordVector.clear();
	}

	public void throwYut(int type) {
		int numOfFront = 0;
		if (type == 0) {
			boolean[] throwResult = new boolean[CONSTANT.YUTNUM];
			numOfFront = 0;
			for (int i = 0; i < yutnori.getYutSet().length; i++) {
				if (throwResult[i] = yutnori.getYutSet()[i].getIsFront()) {
					numOfFront++;
				}
			}
			// 백도
			if (numOfFront == 1 && throwResult[CONSTANT.YUTNUM - 1])
				numOfFront = -1;
			if (numOfFront == 0)
				numOfFront = 5;

		}
		if (type == 1) // 도 개 걸 윷 모 백도 순
			numOfFront = 1;
		if (type == 2)
			numOfFront = 2;
		if (type == 3)
			numOfFront = 3;
		if (type == 4)
			numOfFront = 4;
		if (type == 5)
			numOfFront = 5;
		if (type == 6)
			numOfFront = -1;
		throwYutResultVector.add(numOfFront);
		
		if(numOfFront == 4 || numOfFront == 5)
			numOfThrowChance++;
		numOfThrowChance--;
		notifyThrowChanceObserver(numOfThrowChance);
		notifyYutResultObserver(numOfFront);
	}

	public void movePiece(Tile selectTile, Tile targetTile) {
		int catchedTeam = -1;
		int numOfCatchedPiece = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();

		if (!targetTile.getPieceList().isEmpty() && !selectTile.getPieceList().isEmpty()) {
			if (targetTile.getPieceList().get(0).getTeam() != selectTile.getPieceList().get(0).getTeam()) {
				catchedTeam = targetTile.getPieceList().get(0).getTeam();

				for (int i=0; i<CONSTANT.PIECENUM; i++) {
					if (yutnori.getBoard().getWaitingPieceBoard()[catchedTeam][i].getPieceList().isEmpty()) {
						if(numOfCatchedPiece < targetTile.getPieceList().size()) {
							targetTile.getPieceList().get(numOfCatchedPiece).setIsStartFalse();
							pieceList.add(targetTile.getPieceList().get(numOfCatchedPiece));
							yutnori.getBoard().getWaitingPieceBoard()[catchedTeam][i].putPiece(pieceList);
							pieceList.clear();
							numOfCatchedPiece++;
						}
					}
				}
				targetTile.removePiece();
				this.numOfThrowChance++;
				notifyThrowChanceObserver(numOfThrowChance);
			}
		}

		targetTile.putPiece(selectTile.getPieceList());
		
		for(int i=0; i<selectTile.getPieceList().size(); i++) {
			selectTile.getPieceList().get(i).setIsStartTrue();
		}
		selectTile.removePiece();
		notifyBoardObserver(this.yutnori.getBoard());
	}

	public void getCanGoTile(Tile selectTile) {
		int distance;
		Iterator<Integer> distanceIterator = throwYutResultVector.iterator();
		Cord currentCord = new Cord();
		Cord canGoCord;
		boolean isStart;

		while(distanceIterator.hasNext()) {
			canGoCord = new Cord();
			isStart = selectTile.getPieceList().get(0).getIsStart();
			distance = distanceIterator.next();

			if(!selectTile.getPieceList().isEmpty() && selectTile.getPieceList().get(0).getTeam() == playerID) {
				currentCord.setCord(selectTile.getX(), selectTile.getY());
				currentCord.transform(distance, isStart);
				canGoCord.setCord(currentCord.getX(), currentCord.getY());
				canGoCordVector.addElement(canGoCord);
			}
		}

		notifyHighlightObserver(canGoCordVector);
	}
	
	public void cancelHighlight() {
		canGoCordVector.clear();
		notifyBoardObserver(this.yutnori.getBoard());
	}
	
	public void deleteDistance(Tile selectTile, Tile targetTile) {
		int distance;
		Cord beforeCord = new Cord();
		Cord afterCord = new Cord();
		beforeCord.setCord(selectTile.getX(), selectTile.getY());
		afterCord.setCord(targetTile.getX(), targetTile.getY());
		distance = afterCord.distance(beforeCord);

		int result = 0;
		Iterator<Integer> distanceIterator = throwYutResultVector.iterator();
		while (distanceIterator.hasNext()) {
			result = distanceIterator.next();
			if (result == distance) {
				distanceIterator.remove();
				break;
			}
		}
		canGoCordVector.clear();
	}
	
	public void deleteDistance(int distance) {
		int result = 0;
		Iterator<Integer> distanceIterator = throwYutResultVector.iterator();
		while (distanceIterator.hasNext()) {
			result = distanceIterator.next();
			if (result == distance) {
				distanceIterator.remove();
				break;
			}
		}
		canGoCordVector.clear();
	}
	
	public int getNumOfPassPiece() {
		return this.numOfPassPiece;
	}
	
	public boolean isDistance(int dis) {
		for(int i = 0; i < this.throwYutResultVector.size(); i++)
			if(dis == this.throwYutResultVector.get(i)) {
				return true;
			}
		return false;
	}
}