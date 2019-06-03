package view;

import java.util.Vector;

import model.Cord;
import model.Model;
import model.Player;

public interface Observer {
	void updateYutResultPanel(Model model);
	void updateYutResultPanel(Player player);
	void updateRestPiecePanel(Player player);
	void highlightCanGoTile(Vector<Cord> highlightCord);
}
