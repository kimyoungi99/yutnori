package view;

import java.awt.event.ActionListener;

import model.Model;

public class TileButton extends PieceButton{

	public TileButton(int x, int y) {
		super(x, y);
	}

	/*
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
	*/
	
	public void addTileListener(ActionListener e) {
		this.addActionListener(e);
	}
}
