package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import view.Observer;

public class Player implements Observable {
	private Model model;
	private static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfThrowChance = 0;
	private int numOfRestPiece = CONSTANT.PIECENUM;
	private int numOfPassPiece = 0;
	private ClickData clickData = new ClickData();
	private Vector<Integer> throwYutResultVector = new Vector<Integer>();
	private Vector<Cord> canGoCordVector = new Vector<Cord>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public Player(int playerID, Model model) {
		this.playerID = playerID;
		this.model = model;
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

	public int getNumOfPassPiece() {
		return this.numOfPassPiece;
	}

	public Vector<Integer> getthrowYutResultVector() {
		return throwYutResultVector;
	}

	public Vector<Cord> getCanGoCordVector() {
		return canGoCordVector;
	}

	public Yutnori getYutnori() {
		return yutnori;
	}

	public ClickData getClickData() {
		return clickData;
	}

	public void addNumOfThrowChance() {
		numOfThrowChance++;
		notifyTurnObserver(playerID);
	}

	public int getNumOfThrowChance() {
		return numOfThrowChance;
	}

	public void throwYut(int type) {
		if (numOfThrowChance > 0) {
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

			if (numOfFront == 4 || numOfFront == 5)
				numOfThrowChance++;
			numOfThrowChance--;
			clickData.setStatus(1);
			notifyThrowChanceObserver(numOfThrowChance);
			notifyYutResultObserver(numOfFront);
		} else {
			System.out.println("더 이상 던질 수 없습니다.");
		}
	}

	public boolean movePiece(int x, int y, int type) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		gameBoard = yutnori.getBoard().getGameBoard();
		restPieceBoard = yutnori.getBoard().getWaitingPieceBoard();
		Iterator<Cord> cordIterator = canGoCordVector.iterator();
		Cord cord = new Cord();
		Tile selectTile = new Tile(0, 0);
		Tile targetTile = new Tile(0, 0);
		int catchedTeam = -1;
		int numOfCatchedPiece = 0;
		int size = 0;
		boolean isMove = false;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();

		if (type == 0) {
			targetTile = gameBoard[x][y];
			if (clickData.getStatus() == 2)
				selectTile = restPieceBoard[clickData.getSelectedX()][clickData.getSelectedY()];
			else if (clickData.getStatus() == 3)
				selectTile = gameBoard[clickData.getSelectedX()][clickData.getSelectedY()];
		} else if (type == 1) {
			selectTile = gameBoard[clickData.getSelectedX()][clickData.getSelectedY()];
			targetTile = new Tile(999, 999);
		}

		while (cordIterator.hasNext()) {
			cord = cordIterator.next();
			if (type == 0) {
				if (cord.getX() == x && cord.getY() == y) {
					isMove = true;
				}
			} else if (type == 1) {
				if (cord.getX() == 999 && cord.getY() == 999) {
					isMove = true;
					size = selectTile.getPieceList().size();
					break;
				}
			}
		}
		
		if (isMove) {
			if (!targetTile.getPieceList().isEmpty() && !selectTile.getPieceList().isEmpty()) {
				if (targetTile.getPieceList().get(0).getTeam() != selectTile.getPieceList().get(0).getTeam()) {
					catchedTeam = targetTile.getPieceList().get(0).getTeam();

					for (int i = 0; i < CONSTANT.PIECENUM; i++) {
						if (yutnori.getBoard().getWaitingPieceBoard()[catchedTeam][i].getPieceList().isEmpty()) {
							if (numOfCatchedPiece < targetTile.getPieceList().size()) {
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

			for (int i = 0; i < selectTile.getPieceList().size(); i++) {
				selectTile.getPieceList().get(i).setIsStartTrue();
			}
			selectTile.removePiece();
			notifyBoardObserver(this.yutnori.getBoard());
			

			if(type == 0) {
				deleteDistance(selectTile, targetTile);
				model.turnCheck();
			}
			else if(type == 1) {
				numOfPassPiece += size;
				canGoCordVector.clear();
				/*
				SelectPopUpFrame selectPopUpFrame = new SelectPopUpFrame(clickData.getSelectedX(), clickData.getSelectedX(), model);
				if (numOfPassPiece == CONSTANT.PIECENUM) {
					FinalFrame finalFrame = new FinalFrame(model.getTurn(), sf);
					finalFrame.setVisible(true);
					System.out.println("Player" + model.getTurn() + " Win");
				} else {
					selectPopUpFrame.setVisible(true);
				}
				*/
			}
			clickData.setStatus(1);
		}
		else if(gameBoard[x][y].getPieceList().isEmpty() || gameBoard[x][y].getPieceList().get(0).getTeam() != playerID) {
			if(type == 0) {
				clickData.setStatus(1);
				cancelHighlight();
			}
		}
		else {
			if(type == 0)
				this.calculateCanGoTile(x, y, 1);
		}
		return isMove;
	}

	public void calculateCanGoTile(int x, int y, int type) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		Tile selectTile = new Tile(0, 0);
		gameBoard = yutnori.getBoard().getGameBoard();
		restPieceBoard = yutnori.getBoard().getWaitingPieceBoard();
		Iterator<Integer> distanceIterator = throwYutResultVector.iterator();
		Cord currentCord = new Cord();
		Cord canGoCord;
		boolean isStart;
		int distance;

		if (type == 0) {
			selectTile = restPieceBoard[x][y];
		} else if (type == 1) {
			selectTile = gameBoard[x][y];
		}

		if (clickData.getStatus() != 0) {
			if (selectTile.getPieceList().isEmpty() || selectTile.getPieceList().get(0).getTeam() != playerID) {
				cancelHighlight();
				clickData.setStatus(1);
			} else {
				if (type == 0) {
					clickData.setClickData(2, x, y);
				} else if (type == 1) {
					clickData.setClickData(3, x, y);
				}
				cancelHighlight();
				while (distanceIterator.hasNext()) {
					canGoCord = new Cord();
					isStart = selectTile.getPieceList().get(0).getIsStart();
					distance = distanceIterator.next();

					if (!selectTile.getPieceList().isEmpty()
							&& selectTile.getPieceList().get(0).getTeam() == playerID) {
						currentCord.setCord(selectTile.getX(), selectTile.getY());
						currentCord.transform(distance, isStart);
						canGoCord.setCord(currentCord.getX(), currentCord.getY());
						canGoCordVector.addElement(canGoCord);
					}
				}

				notifyHighlightObserver(canGoCordVector);
			}
		}

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

	public boolean isDistance(int dis) {
		for (int i = 0; i < this.throwYutResultVector.size(); i++)
			if (dis == this.throwYutResultVector.get(i)) {
				return true;
			}
		return false;
	}
}