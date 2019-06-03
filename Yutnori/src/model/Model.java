package model;

import java.util.ArrayList;

import view.Observer;

public class Model implements Observable{
	private boolean gameEnd = false;
	private int turn = 0;
	private Player[] player = new Player[CONSTANT.PLAYERNUM];
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public Model() {
		for(int i = 0; i < player.length; i++) {
			player[i] = new Player(i);
		}
	}
	
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
	public void notifyYutResultObserver() {}
	
	@Override
	public void notifyRestPieceObserver() {}

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
	
	public Player getTurnPlayer() {
		return this.player[turn % CONSTANT.PLAYERNUM];
	}
}
