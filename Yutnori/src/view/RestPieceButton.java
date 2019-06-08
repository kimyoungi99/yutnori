package view;

import java.awt.event.ActionListener;

public class RestPieceButton extends PieceButton {

	public RestPieceButton(int x, int y) {
		super(x, y);
	}

	public void addRestPieceListener(ActionListener e) {
		this.addActionListener(e);
	}
}

