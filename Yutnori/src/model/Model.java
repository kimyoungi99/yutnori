package model;

public class Model {
	private boolean gameEnd = false;
	private int turn = 0;
	private Player[] player = new Player[CONSTANT.PLAYERNUM];

	public boolean getGameEnd() {
		return gameEnd;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Player[] getPlayer() {
		return player;
	}
	
	public void nextTurn() {
		turn++;
		if(turn == 4)
			turn = 0;
	}
	
	public void setGameEnd() {
		gameEnd = true;
	}
}
