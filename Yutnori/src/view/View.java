package view;

import javax.swing.ImageIcon;

import controller.Controller;
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
	private ImageIcon P1Image = new ImageIcon("src/view/img/P1_Piece.png");
	private Controller controller;

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
		case 0:
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
	public void updateRestBoard(Player player) {
		for(int i = 0; i < 5; i++) {
			this.controller.getRestPieceButton()[player.getPlayerId()][i].setIcon(null);
		}
		for(int i = 0; i < this.controller.getModel().getPlayer()[player.getPlayerId()].getNumOfRestPiece(); i++)
			this.controller.getRestPieceButton()[player.getPlayerId()][i].setIcon(P1Image);
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
