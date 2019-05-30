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
}

