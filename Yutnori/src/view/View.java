package view;

import controller.Controller;
import model.Model;
import model.Player;

public class View implements Observer {

	//private Model model = new Model();
	//private Model model;
	private Controller controller;

	@Override
	public void updateYutResultPanel(Model model) {
		
	}
	
	@Override
	public void updateYutResultPanel(Player player) {
		System.out.println("Hello");
		System.out.println(player.getthrowYutResult());
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
