package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import view.Observer;

//public class Player implements Observable{
public class Player implements Observable {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = CONSTANT.PIECENUM;
	// private int numOfOnBoardPiece = 0;
	private int numOfPassPiece = 0;
	private int throwYutResult;
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
	public void notifyYutResultObserver() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateYutResultPanel(this);
		}
	}

	@Override
	public void notifyRestPieceObserver() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateRestPiecePanel(this);
		}
	}

	@Override
	public void notifyHighlightObserver(Vector<Cord> highlightCord) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.highlightCanGoTile(highlightCord);
		}
	}

	@Override
	public void notifyBoardObserver(Board board) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.updateBoard(board);
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

	public int getthrowYutResult() {
		return throwYutResult;
	}
	
	public Vector<Cord> getCanGoCordVector() {
		return canGoCordVector;
	}

	/*
	public void deleteCanGoCordVector(int deleteX, int deleteY) {
		Cord cord = new Cord();
		Iterator<Cord> cordIterator = canGoCordVector.iterator();
		while (cordIterator.hasNext()) {
			cord = cordIterator.next();
			if (cord.getX() == deleteX && cord.getY() == deleteY) {
				cordIterator.remove();
			}
		}
	}
	*/

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

			throwYutResult = numOfFront;
		}
		if (type == 1) // 도 개 걸 윷 모 백도 순
			throwYutResult = 1;
		if (type == 2)
			throwYutResult = 2;
		if (type == 3)
			throwYutResult = 3;
		if (type == 4)
			throwYutResult = 4;
		if (type == 5)
			throwYutResult = 5;
		if (type == 6)
			throwYutResult = -1;

		throwYutResultVector.add(throwYutResult);
		notifyYutResultObserver();
		// return numOfFront;
	}

	public int[] movePiece(Tile selectTile, Tile targetTile) {
		// public boolean movePiece(Tile selectTile, Tile targetTile, boolean isStart) {
		// public boolean movePiece(Cord select, Cord target) {
		// Tile selectTile = yutnori.getBoard().gameBoard[select.getX()][select.getY()];
		// Tile targetTile = yutnori.getBoard().gameBoard[target.getX()][target.getY()];
		int[] returnArray = new int[2];
		int catchedTeam = 0;
		int numOfCatchedPiece = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		/*
		 * ArrayList<Piece> startPiece = new ArrayList<Piece>(); if(isStart) {
		 * startPiece.add(selectTile.getPieceList().get(0)); }
		 */

		if (!targetTile.getPieceList().isEmpty() && !selectTile.getPieceList().isEmpty())
			if (targetTile.getPieceList().get(0).getTeam() != selectTile.getPieceList().get(0).getTeam()) {
				catchedTeam = targetTile.getPieceList().get(0).getTeam();
				for (int i = 0; i < targetTile.getPieceList().size(); i++) {
					for (int j = 0; j < CONSTANT.PIECENUM; j++) {
						if (yutnori.getBoard().getWaitingPieceBoard()[playerID][j].getPieceList().isEmpty()) {
							pieceList.add(targetTile.getPieceList().get(i));
							yutnori.getBoard().getWaitingPieceBoard()[playerID][j].putPiece(pieceList);
							pieceList.clear();
						}
					}
					numOfCatchedPiece++;
				}
				targetTile.removePiece();
			}
		// if(!isStart)
		targetTile.putPiece(selectTile.getPieceList());

		// else
		// targetTile.putPiece(startPiece);
		// if(!isStart)
		selectTile.removePiece();
		// else
		// selectTile.getPieceList().remove(selectTile.getPieceList().size()-1);
		returnArray[0] = catchedTeam;
		returnArray[1] = numOfCatchedPiece;
		notifyBoardObserver(this.yutnori.getBoard());
		return returnArray;
	}

	// public Vector<Cord> getCanGoTile(Tile selectTile, Vector<Integer> result) {
	public void getCanGoTile(Tile selectTile) {
		int distance;
		//Vector<Vector<Cord>> canGoCordVectorforEveryDistance = new Vector<Vector<Cord>>();
		//Tile[][] gameBoard = yutnori.getBoard().getGameBoard();
		Iterator<Integer> distanceIterator = throwYutResultVector.iterator();
		Cord currentCord = new Cord();
		Cord canGoCord;
		boolean isStart = true;

		while(distanceIterator.hasNext()) {
			canGoCord = new Cord();
			isStart = true;
			distance = distanceIterator.next();
			if(selectTile.getX() == 0 && selectTile.getY() == 0)
				isStart = false;
			if(!selectTile.getPieceList().isEmpty() && selectTile.getPieceList().get(0).getTeam() == playerID) {
				System.out.println(selectTile.getX() + ","+ selectTile.getY());
				currentCord.setCord(selectTile.getX(), selectTile.getY());
				currentCord.transform(distance, isStart);
				canGoCord.setCord(currentCord.getX(), currentCord.getY());
				canGoCordVector.addElement(canGoCord);
			}
			/*
			for(int i=0; i<6; i++) {
				for(int j=0; j<5; i++) {
					if(!gameBoard[i][j].getPieceList().isEmpty() && gameBoard[i][j].getPieceList().get(0).getTeam() == playerID) {
						currentCord.setCord(i, j);
						currentCord.transform(distance, isStart);
						canGoCord.setCord(currentCord.getX(), currentCord.getY());
						canGoCordVector.add(canGoCord);
					}
				}
			}
			
			canGoCordVectorforEveryDistance.add(canGoCordVector);
			*/
		}

		notifyHighlightObserver(canGoCordVector);
		//return canGoCordVector;
	}

	public void decreaseNumOfRestPiece() {
		this.numOfRestPiece--;
		// 좀 더 생각
		// this.notifyRestPieceObserver();
	}
	
	public void cancelHighlight() {
		notifyBoardObserver(this.yutnori.getBoard());
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
	}
}