package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CONSTANT;
import model.Model;
import view.FinalFrame;
import view.SelectPopUpFrame;
import view.StartFrame;

public class ExitListener implements ActionListener{
	Model model;
	StartFrame startFrame;
	
	public ExitListener(Model model, StartFrame startFrame) {
		this.model = model;
		this.startFrame = startFrame;
	}
	
	public ExitListener(Model model) {
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean isMove = false;
		isMove = model.getTurnPlayer().movePiece(0, 0, 1);
		if (isMove) {
			SelectPopUpFrame selectPopUpFrame = new SelectPopUpFrame(model.getTurnPlayer().getClickData().getSelectedX(), model.getTurnPlayer().getClickData().getSelectedY(), model);
			if (model.getTurnPlayer().getNumOfPassPiece() == CONSTANT.PIECENUM) {
				//FinalFrame finalFrame = new FinalFrame(model.getTurn(), sf);
				FinalFrame finalFrame = new FinalFrame(model.getTurn(), startFrame);
				finalFrame.setVisible(true);
			} else {
				selectPopUpFrame.setVisible(true);
			}
		}
    }
}
