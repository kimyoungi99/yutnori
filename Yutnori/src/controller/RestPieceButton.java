package controller;

import java.awt.event.ActionEvent;

import model.Model;

public class RestPieceButton extends PieceButton {
	private int x, y;

	public RestPieceButton(int x, int y, Model model) {
		super(model);
		this.x = x;
		this.y = y;
	}

	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer().calculateCanGoTile(x, y, 0);
	}
}
