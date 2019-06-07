package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Piece;
import model.Tile;

public class RestPieceButton extends PieceButton {
	private int x, y;

	public RestPieceButton(int x, int y, Model model) {
		super(model);
		this.x = x;
		this.y = y;
	}

	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer().getCanGoTile(x, y, 0);
	}
}
