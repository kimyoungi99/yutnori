package view;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;

import model.Board;
import model.CONSTANT;
import model.Cord;
import model.Tile;

public class ConcreteObserver implements Observer {
	private ImageIcon DaoImage = new ImageIcon("src/view/img/Dao.png");
	private ImageIcon GaeImage = new ImageIcon("src/view/img/Gae.png");
	private ImageIcon GurlImage = new ImageIcon("src/view/img/Gurl.png");
	private ImageIcon YutImage = new ImageIcon("src/view/img/Yut.png");
	private ImageIcon MoeImage = new ImageIcon("src/view/img/Moe.png");
	private ImageIcon BackDaoImage = new ImageIcon("src/view/img/BackDao.png");
	private ImageIcon highlightImage = new ImageIcon("src/view/img/highlight.png");
	private ImageIcon noneImage = new ImageIcon("src/view/img/none.png");
	private ImageIcon exitButtonImage = new ImageIcon("src/view/img/End.png");
	private ImageIcon exitButtonHighlightImage = new ImageIcon("src/view/img/End_highlight.png");
	private ImageIcon pieceImage[][] = new ImageIcon[4][5];
	private MainFrame mainFrame;
	
	public ConcreteObserver() {
		for(int i=0; i<pieceImage.length; i++) {
			for(int j=0; j<pieceImage[0].length; j++) {
				String address = "src/view/img/";
				address = address + Integer.toString(i+1) + "-" + Integer.toString(j+1) + ".png";
				pieceImage[i][j] = new ImageIcon(address);
			}
		}
	}
	
	@Override
	public void updateYutResultPanel(int result) {
		int throwRes = result;
		switch(throwRes) {
		case -1:
			mainFrame.getThrowResultLabel().setIcon(this.BackDaoImage);
			break;
		case 5:
			mainFrame.getThrowResultLabel().setIcon(this.MoeImage);
			break;
		case 1:
			mainFrame.getThrowResultLabel().setIcon(this.DaoImage);
			break;
		case 2:
			mainFrame.getThrowResultLabel().setIcon(this.GaeImage);
			break;
		case 3:
			mainFrame.getThrowResultLabel().setIcon(this.GurlImage);
			break;
		case 4:
			mainFrame.getThrowResultLabel().setIcon(this.YutImage);
			
		}
	}
	
	@Override
	public void updateHighlightCanGoTile(Vector<Cord> highlightCord) {
		Cord cord = new Cord();
		Iterator<Cord> cordIterator = highlightCord.iterator();
		while(cordIterator.hasNext()) {
			cord = cordIterator.next();
			if(cord.getX() == 999)
				mainFrame.getGameBoardPanel().getExitButton().setIcon(this.exitButtonHighlightImage);
			else
				mainFrame.getGameBoardPanel().getTileButton()[cord.getX()][cord.getY()].setIcon(highlightImage);
		}
	}
	
	@Override
	public void updateBoard(Board board) {
		Tile[][] gameBoard = new Tile[6][5];
		Tile[][] restPieceBoard = new Tile[CONSTANT.PLAYERNUM][CONSTANT.PIECENUM];
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard[0].length; j++) {
				gameBoard[i][j] = board.getGameBoard()[i][j];
				if(gameBoard[i][j].getPieceList().isEmpty()) {
					mainFrame.getGameBoardPanel().getTileButton()[i][j].setIcon(noneImage);
				}
				else{
					mainFrame.getGameBoardPanel().getTileButton()[i][j].setIcon(pieceImage[gameBoard[i][j].getPieceList().get(0).getTeam()][gameBoard[i][j].getPieceList().size() - 1]);
				}
			}
		}
		for(int i=0; i<restPieceBoard.length; i++) {
			for(int j=0; j<restPieceBoard[0].length; j++) {
				restPieceBoard[i][j] = board.getWaitingPieceBoard()[i][j];
				if(restPieceBoard[i][j].getPieceList().isEmpty()) {
					mainFrame.getRestPieceButton()[i][j].setIcon(noneImage);
				}
				else{
					mainFrame.getRestPieceButton()[i][j].setIcon(pieceImage[restPieceBoard[i][j].getPieceList().get(0).getTeam()][0]);
				}
			}
		}
		mainFrame.getGameBoardPanel().getExitButton().setIcon(this.exitButtonImage);
	}
	
	@Override
	public void updateThrowChanceLabel(int chance) {
		mainFrame.getGameInfoPanel().getThrowChanceLabel().setText(Integer.toString(chance));
	}
	
	@Override
	public void updateTurnLabel(int turn) {
		mainFrame.getGameInfoPanel().getThrowChanceLabel().setText("1");
		mainFrame.getGameInfoPanel().getTurnLabel().setIcon(pieceImage[turn][0]);
	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
