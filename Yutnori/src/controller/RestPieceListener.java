package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class RestPieceListener implements ActionListener {
	Model model;
	int x, y;

	public RestPieceListener(Model model, int x, int y) {
		this.x = x;
		this.y = y;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer().calculateCanGoTile(x, y, 0);
	}
}