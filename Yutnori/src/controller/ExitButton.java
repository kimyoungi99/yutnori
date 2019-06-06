package controller;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Tile;

public class ExitButton extends PieceButton {

	public ExitButton(Model model) {
		super(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile selectTile = new Tile(0, 0);
		Tile finish = new Tile(999, 999);
		boolean isMove = false;
		int size = 0;
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		if (model.getClickData().getStatus() == 3) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == 999 && cord.getY() == 999) {
					isMove = true;
					selectTile = gameBoard[model.getClickData().getSelectedX()][model.getClickData().getSelectedY()];
					size = selectTile.getPieceList().size();
					model.getTurnPlayer().movePiece(selectTile, finish);
					break;
				}
			}
		}
		if (isMove) {
			SelectPopUpFrame selectPopUpFrame = new SelectPopUpFrame(model.getClickData().getSelectedX(), model.getClickData().getSelectedX(), model);
			boolean isClicked = false;
			model.getClickData().setStatus(1);
			model.getTurnPlayer().setNumOfPassPiece(size);
			model.getTurnPlayer().getCanGoCordVector().clear();

			if (model.getTurnPlayer().getNumOfPassPiece() == CONSTANT.PIECENUM) {
				FinalFrame finalFrame = new FinalFrame(model.getTurn());
				finalFrame.setVisible(true);
				System.out.println("Player" + model.getTurn() + " Win");
			} else {
				selectPopUpFrame.setVisible(true);
			}
		}
	}
}