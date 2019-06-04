package model;

import java.util.Vector;

import view.Observer;

public interface Observable {
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyYutResultObserver();
	public void notifyRestPieceObserver();
	public void notifyHighlightObserver(Vector<Cord> highlightCord);
	public void notifyBoardObserver(Board board);
}
