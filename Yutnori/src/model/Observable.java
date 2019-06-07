package model;

import java.util.Vector;

import view.Observer;

public interface Observable {
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyYutResultObserver(int result);
	public void notifyHighlightObserver(Vector<Cord> highlightCord);
	public void notifyBoardObserver(Board board);
	public void notifyThrowChanceObserver(int chance);
	public void notifyTurnObserver(int turn);
}
