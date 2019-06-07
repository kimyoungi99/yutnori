package controller;

import java.awt.event.ActionEvent;

import model.CONSTANT;
import model.Model;

public class ExitButton extends PieceButton {
	private StartFrame sf;
	public ExitButton(Model model, StartFrame sf) {
		super(model);
		this.sf = sf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isMove = false;
		isMove = model.getTurnPlayer().movePiece(0, 0, 1);
		if (isMove) {
			SelectPopUpFrame selectPopUpFrame = new SelectPopUpFrame(model.getTurnPlayer().getClickData().getSelectedX(), model.getTurnPlayer().getClickData().getSelectedY(), model);
			if (model.getTurnPlayer().getNumOfPassPiece() == CONSTANT.PIECENUM) {
				FinalFrame finalFrame = new FinalFrame(model.getTurn(), sf);
				finalFrame.setVisible(true);
			} else {
				selectPopUpFrame.setVisible(true);
			}
		}
	}
}