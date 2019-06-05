package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Piece;
import model.Tile;

public class ExitButton extends JButton implements ActionListener {
	private Model model;
	
	public ExitButton(Model model) {
		this.setText("exit");
		this.model = model;
		addActionListener(this);
	}
	
	//0: 윷 던지기 전, 1: 윷 던지고 움직일 말 선택전, 2: 움직일 말로 출발 말 선택, 3: 움직일 말로 기존 판 위의 말 선택
	public void actionPerformed(ActionEvent e) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile temp = new Tile(999, 999);
		boolean isMove = false;
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		Iterator<Cord> cordIterator = model.getTurnPlayer().getCanGoCordVector().iterator();
		Cord cord = new Cord();
		Cord beforeCord = new Cord();
		Cord afterCord = new Cord();
		int tempX = 0, tempY = 0;
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		gameBoard = model.getTurnPlayer().yutnori.getBoard().getGameBoard();
		restPieceBoard = model.getTurnPlayer().yutnori.getBoard().getWaitingPieceBoard();
		System.out.println(model.getStatus());
		if (model.getStatus() == 3) {
			while (cordIterator.hasNext()) {
				cord = cordIterator.next();
				if (cord.getX() == 999 && cord.getY() == 999) {
					// deleteX = x;
					// deleteY = y;
					isMove = true;
					model.getTurnPlayer().movePiece(gameBoard[model.getSelectX()][model.getSelectY()], temp);
					// canGoCordVector에서 움직인 칸(x, y) 제외, 새로 하이라이트
				}
			}
		}
		if (isMove) {
			model.getTurnPlayer().setNumOfPassPiece(model.getTurnPlayer().getNumOfPassPiece() - 1);
		}
		else if (!pieceList.isEmpty() && pieceList.get(0).getTeam() == model.getTurn()) {
				
		} 
		else if (!pieceList.isEmpty() && pieceList.get(0).getTeam() != model.getTurn()) {
			model.setStatus(1);
			model.setSelectX(0);
			model.setSelectY(0);
			model.getTurnPlayer().clearCanGoCordVector();
			model.getTurnPlayer().cancelHighlight();
		}
	}
}