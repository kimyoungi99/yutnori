package view;

import javax.swing.JPanel;

import controller.Controller;
import model.Model;

public class View extends JPanel{
	
	private Model model = new Model();
	private Controller controller = new Controller(model);
	
	public View() {	
		
	}
	
	public void paint() {
		
	}
	
	public void repaint() {
		
	}
}
