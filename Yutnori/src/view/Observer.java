package view;

import java.util.Vector;

import model.Board;
import model.Cord;
import model.Model;
import model.Player;

public interface Observer {
	public void updateYutResultPanel(int result);
	public void updateBoard(Board board);
	public void updateHighlightCanGoTile(Vector<Cord> highlightCord);
	public void updateThrowChanceLabel(int chance);
	public void updateTurnLabel(int turn);
}
