package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import view.Observer;

//public class Player implements Observable{
public class Player implements Observable{

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = CONSTANT.PIECENUM;
	private int throwYutResult;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void deleteObserver(Observer o) {
        int i = observers.indexOf(o);                
        if(i>=0){
            observers.remove(i);
        }
	}
	
	@Override
	public void notifyObserver() {
        for(int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.updateYutResultPanel(this);
        }
	}
	
	public Player(int playerID) {
		this.playerID = playerID;
	}

	public void setNumOfRestPiece(int numOfPassPiece) {
		this.numOfRestPiece -= numOfPassPiece;
	}

	public int getNumOfRestPiece() {
		return numOfRestPiece;
	}
	
	public int getthrowYutResult() {
		return throwYutResult;
	}

	public int throwYut(int type) {
		int numOfFront = 0;
		if(type == 0) {
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
			
			throwYutResult = numOfFront;
		}
		if(type == 1) // 도 개 걸 윷 모 백도 순
			throwYutResult = 1;
		if(type == 2)
			throwYutResult = 2;
		if(type == 3)
			throwYutResult = 3; 
		if(type == 4)
			throwYutResult = 4;
		if(type == 5)
			throwYutResult = 0;
		if(type == 6)
			throwYutResult = -1;
			
		notifyObserver();
		return numOfFront;
	}
	
	public boolean movePiece(Tile selectTile, Tile targetTile, boolean isStart) {
		// public boolean movePiece(Cord select, Cord target) {
		// Tile selectTile = yutnori.getBoard().gameBoard[select.getX()][select.getY()];
		// Tile targetTile = yutnori.getBoard().gameBoard[target.getX()][target.getY()];

		boolean isCatch = false;
		ArrayList<Piece> startPiece = new ArrayList<Piece>();
		if(isStart) {
			startPiece.add(selectTile.getPieceList().get(0));
		}
		
		if(!targetTile.getPieceList().isEmpty() && !(targetTile.getPieceList().get(0).getTeam() == selectTile.getPieceList().get(0).getTeam())) {
			yutnori.getBoard().getWaitingPieceBoard()[playerID].putPiece(targetTile.getPieceList());
			targetTile.removePiece();
			isCatch = true;
		}
		if(!isStart)
			targetTile.putPiece(selectTile.getPieceList());
		else
			targetTile.putPiece(startPiece);
		if(!isStart)
			selectTile.removePiece();
		else
			selectTile.getPieceList().remove(selectTile.getPieceList().size()-1);

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
		}
		return canGoCordVectorforEveryDistance;
	}
}
