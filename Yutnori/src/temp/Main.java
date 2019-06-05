package temp;

import controller.Controller;

public class Main {
	public static void main(String[] args) {
		System.out.println("Consone ON");
		Controller controller = new Controller(3, 3);
		controller.init();
		controller.setVisible(true);
	}
}
