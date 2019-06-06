package model;

public class Model{
	private boolean gameEnd = false;
	private int turn = 0;
	private Player[] player = new Player[CONSTANT.PLAYERNUM];
	private int status = 0;		
	//0: 윷 던지기 전, 1: 윷 던지고 움직일 말 선택전, 2: 움직일 말로 출발 말 선택, 3: 움직일 말로 기존 판 위의 말 선택
	private int selectX = 0, selectY = 0;
	
	public Model() {
		for(int i = 0; i < player.length; i++) {
			player[i] = new Player(i);
		}
	}

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
		player[turn].getthrowYutResultVector().clear();
		turn++;
		if(turn == CONSTANT.PLAYERNUM)
			turn = 0;
		this.getTurnPlayer().addNumOfThrowChance();
		System.out.println("Turn" + turn);
		status = 0;
	}
	
	public void turnCheck() {
		if(this.getTurnPlayer().getNumOfThrowChance() == 0 && this.getTurnPlayer().getthrowYutResultVector().isEmpty()) {
			nextTurn();
		}
	}
	
	public void setGameEnd() {
		gameEnd = true;
	}
	
	public Player getTurnPlayer() {
		return this.player[turn % CONSTANT.PLAYERNUM];
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public int getSelectX() {
		return selectX;
	}
	
	public int getSelectY() {
		return selectY;
	}
	
	public void setSelectX(int selectX) {
		this.selectX = selectX;
	}
	
	public void setSelectY(int selectY) {
		this.selectY = selectY;
	}
	
}
