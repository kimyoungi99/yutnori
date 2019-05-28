package model;

public class Player {

	public static Yutnori yutnori = new Yutnori();
	private int playerID;
	private int numOfRestPiece = 4;
	private int numOfRestTurn = 1;

	public Player(int playerID) {
		this.playerID = playerID;
	}

	// 통과한 말이 발생할 때 마다 호출(numOfPassPiece: 통과한 말 개수)
	public void setNumOfRestPiece(int numOfPassPiece) {
		this.numOfRestPiece -= numOfPassPiece;
	}

	public int throwYut() {
		int numOfFront = 0;
		boolean[] throwResult = new boolean[4];
		for (int i = 0; i < yutnori.getYutSet().length; i++) {
			if (throwResult[i] = yutnori.getYutSet()[i].getIsFront()) {
				System.out.println(i);
				numOfFront++;
			}
		}
		// 백도
		if (numOfFront == 1 && throwResult[3]) {
			numOfFront = -1;
		}

		else if (numOfFront == 0 || numOfFront == 4) {
			// 윷 던지기 추가 1회 부여
			numOfRestTurn++;

			// 모
			if (numOfFront == 0) {
				numOfFront = 5;
			}
		}
		numOfRestTurn--;
		// 도: 1, 개: 2, 걸: 3, 윷: 4, 모: 5, 백도: -1
		return numOfFront;
	}
}
