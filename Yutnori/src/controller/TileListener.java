package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class TileListener implements ActionListener {
	Model model;
	int x, y;

	public TileListener(Model model, int x, int y) {
		this.x = x;
		this.y = y;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		if (model.getTurnPlayer().getClickData().getStatus() == 1) {
			model.getTurnPlayer().calculateCanGoTile(x, y, 1);
		} else if (model.getTurnPlayer().getClickData().getStatus() > 1) {
			model.getTurnPlayer().movePiece(x, y, 0);
			// if (!isMove)
			// model.getTurnPlayer().getCanGoTile(x, y, 1);
		}
	}
}