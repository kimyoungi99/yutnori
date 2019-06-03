package view;

import model.Model;
import model.Player;

public interface Observer {
	void updateYutResultPanel(Model model);
	void updateYutResultPanel(Player player);
	void updateRestPiecePanel(Player player);
}
