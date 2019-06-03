package view;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;

import controller.Controller;
import model.CONSTANT;
import model.Cord;
import model.Model;
import model.Player;

public class View implements Observer {

	//private Model model = new Model();
	//private Model model;
	private ImageIcon DaoImage = new ImageIcon("src/view/img/Dao.jpg");
	private ImageIcon GaeImage = new ImageIcon("src/view/img/Gae.jpg");
	private ImageIcon GurlImage = new ImageIcon("src/view/img/Gurl.jpg");
	private ImageIcon YutImage = new ImageIcon("src/view/img/Yut.jpg");
	private ImageIcon MoeImage = new ImageIcon("src/view/img/Moe.jpg");
	private ImageIcon BackDaoImage = new ImageIcon("src/view/img/BackDao.jpg");
	private ImageIcon highlightImage = new ImageIcon("src/view/img/highlight.png");
	private ImageIcon pieceImage[][] = new ImageIcon[4][5];
	private Controller controller;
	
	public View() {
		for(int i=0; i<pieceImage.length; i++) {
			for(int j=0; j<pieceImage[0].length; j++) {
				String address = "src/view/img/";
				address = address + Integer.toString(i+1) + "-" + Integer.toString(j+1) + ".png";
				pieceImage[i][j] = new ImageIcon(address);
			}
		}
	}

	@Override
	public void updateYutResultPanel(Model model) {
	}
	
	@Override
	public void updateYutResultPanel(Player player) {
		int throwRes = player.getthrowYutResult();
		switch(throwRes) {
		case -1:
			this.controller.getThrowResultLabel().setIcon(this.BackDaoImage);
			break;
		case 5:
			this.controller.getThrowResultLabel().setIcon(this.MoeImage);
			break;
		case 1:
			this.controller.getThrowResultLabel().setIcon(this.DaoImage);
			break;
		case 2:
			this.controller.getThrowResultLabel().setIcon(this.GaeImage);
			break;
		case 3:
			this.controller.getThrowResultLabel().setIcon(this.GurlImage);
			break;
		case 4:
			this.controller.getThrowResultLabel().setIcon(this.YutImage);
			
		}
	}
	
	@Override
	public void updateRestPiecePanel(Player player) {
		for(int i = 0; i < CONSTANT.PIECENUM; i++) {
			this.controller.getRestPieceButton()[player.getPlayerId()][i].setIcon(null);
		}
		for(int i = 0; i < this.controller.getModel().getPlayer()[player.getPlayerId()].getNumOfRestPiece(); i++)
			this.controller.getRestPieceButton()[player.getPlayerId()][i].setIcon(pieceImage[player.getPlayerId()][0]);
	}
	
	@Override
	public void highlightCanGoTile(Vector<Cord> highlightCord) {
		Cord cord = new Cord();
		//System.out.println(cord.getX() + "," + cord.getY());
		Iterator<Cord> cordIterator = highlightCord.iterator();
		while(cordIterator.hasNext()) {
			cord = cordIterator.next();
			controller.getGameBoardPanel().getTileButton()[cord.getX()][cord.getY()].setIcon(highlightImage);
		}
	}
	
	/*
	public View(Model model) {
		this.model = model;
	}
	*/
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void paint() {
	}
}
