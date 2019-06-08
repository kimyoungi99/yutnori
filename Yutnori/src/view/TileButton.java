package view;

import java.awt.event.ActionListener;

public class TileButton extends PieceButton{

	public TileButton(int x, int y) {
		super(x, y);
	}
	
	public void addTileListener(ActionListener e) {
		this.addActionListener(e);
	}
}
