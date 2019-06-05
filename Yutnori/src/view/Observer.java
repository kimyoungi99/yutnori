package view;

import java.util.Vector;

import model.Board;
import model.Cord;
import model.Model;
import model.Player;

public interface Observer {
	public void updateYutResultPanel(Model model);
	public void updateYutResultPanel(Player player);
	public void updateRestPiecePanel(Player player);
	public void updateBoard(Board board);
	public void highlightCanGoTile(Vector<Cord> highlightCord);
}
