package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class RestPieceButton extends PieceButton {

	public RestPieceButton(int x, int y) {
		super(x, y);
	}

	/*
	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer().calculateCanGoTile(x, y, 0);
	}
	*/
	
	public void addRestPieceListener(ActionListener e) {
		this.addActionListener(e);
	}
}

