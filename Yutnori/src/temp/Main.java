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
		Cord t = new Cord();
		int test = -1;
		c.setCord(0, 0);
		t.setCord(0, 0);
		//c.transform(test, false);
		for(int i = 0; i < 20; i++) {
			System.out.printf("%d %d     %d     %d %d\n", c.getX(), c.getY(), c.distance(t), t.getX(), t.getY());
			c.transform(test, true);
			//if(i == 0)
			//	t.transform(test, false);
			//else
			//	t.transform(test, true);
		}
		
	}
	
	
}
