package temp;

import controller.Controller;
import model.Player;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.init();
		controller.setVisible(true);
	}
}
