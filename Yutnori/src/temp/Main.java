package temp;

import controller.Controller;
import model.Cord;
import model.Player;

public class Main {
	public static void main(String[] args) {
		//Controller controller = new Controller();
		//controller.init();
		//controller.setVisible(true);
		
		Cord c = new Cord();
		c.setCord(0, 0);
		c.transform(1, false);
		for(int i = 0; i < 20; i++) {
			System.out.printf("%d %d\n", c.getX(), c.getY());
			c.transform(3, true);
		}
		
	}
	
	
}
