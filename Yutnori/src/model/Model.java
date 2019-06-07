package model;

public class Model{
	private boolean gameEnd = false;
	private int turn = 0;
	private Player[] player = new Player[CONSTANT.PLAYERNUM];
	
	public Model() {
		for(int i = 0; i < player.length; i++) {
			player[i] = new Player(i, this);
		}
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Player[] getPlayer() {
		return player;
	}
	
	public void nextTurn() {
		player[turn].getthrowYutResultVector().clear();
		player[turn].getClickData().setStatus(0);
		turn++;
		if(turn == CONSTANT.PLAYERNUM)
			turn = 0;
		this.getTurnPlayer().addNumOfThrowChance();
	}
	
	public void turnCheck() {
		if(this.getTurnPlayer().getNumOfThrowChance() == 0 && this.getTurnPlayer().getthrowYutResultVector().isEmpty()) {
			nextTurn();
		}
	}

	public Player getTurnPlayer() {
		return this.player[turn % CONSTANT.PLAYERNUM];
	}
	
	public boolean getGameEnd() {
		return gameEnd;
	}
	
	public void setGameEnd() {
		gameEnd = true;
	}
}
