package controller;

import java.awt.event.ActionEvent;

import model.Model;

public class TileButton extends PieceButton{
	int x, y;

	public TileButton(Model model, int x, int y) {
		super(model);
		this.x = x;
		this.y = y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.getTurnPlayer().getClickData().getStatus() == 1) {
			model.getTurnPlayer().calculateCanGoTile(x, y, 1);
		} else if (model.getTurnPlayer().getClickData().getStatus() > 1) {
			model.getTurnPlayer().movePiece(x, y, 0);
			//if (!isMove)
				//model.getTurnPlayer().getCanGoTile(x, y, 1);
		}
	}
}
