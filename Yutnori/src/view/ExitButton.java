package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExitButton extends JButton{
	private StartFrame sf;
	public ExitButton(StartFrame sf) {
		this.sf = sf;
	}

	/*
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
	*/
	
	public void addExitListener(ActionListener e) {
		this.addActionListener(e);
	}

}