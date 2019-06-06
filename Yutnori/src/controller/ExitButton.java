package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Tile;

public class ExitButton extends GameBoardButton{
	
	public ExitButton(Model model) {
		super(model);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile temp = new Tile(999, 999);
		boolean isMove = false;
		int size = 0;
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		//ArrayList<Piece> pieceList = new ArrayList<Piece>();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		if (model.getStatus() == 3) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == 999 && cord.getY() == 999) {
					isMove = true;
					size = gameBoard[model.getSelectX()][model.getSelectY()].getPieceList().size();
					model.getTurnPlayer().movePiece(gameBoard[model.getSelectX()][model.getSelectY()], temp);
					break;
				}
			}
		}
		if (isMove) {
			model.setStatus(1);
			model.getTurnPlayer().setNumOfPassPiece(size);
			model.getTurnPlayer().getCanGoCordVector().clear();

			System.out.println("Player" + model.getTurn() + ": " + model.getTurnPlayer().getNumOfPassPiece());
			if(model.getTurnPlayer().getNumOfPassPiece() == CONSTANT.PIECENUM) {
				FinalFrame finalFrame = new FinalFrame(model.getTurn());
				finalFrame.setVisible(true);
				System.out.println("Player" + model.getTurn() + " Win");
			}
			else {
				SelectPopUpFrame spu = new SelectPopUpFrame(model.getSelectX(), model.getSelectY(), model);
				spu.setVisible(true);
			}
			if(model.getTurnPlayer().getNumOfThrowChance() == 0 && model.getTurnPlayer().getthrowYutResultVector().isEmpty()) {
				model.nextTurn();
			}

		}
		/*
		else if (!pieceList.isEmpty() && pieceList.get(0).getTeam() == model.getTurn()) {

		} 
		else if (pieceList.isEmpty() || pieceList.get(0).getTeam() != model.getTurn()) {
			model.setStatus(1);
			model.getTurnPlayer().clearCanGoCordVector();
			model.getTurnPlayer().cancelHighlight();
		}
		*/
	}
}
