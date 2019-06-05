package temp;

import controller.Controller;
import model.Cord;

public class Main {
	public static void main(String[] args) {
		/*
		Cord cord = new Cord();
		cord.setCord(0,  0);
		cord.transform(5, true);
		System.out.println(cord.getX() + "," + cord.getY());
		cord.transform(4,  false);
		System.out.println(cord.getX() + "," + cord.getY());
		cord.transform(4, false);
		System.out.println(cord.getX() + "," + cord.getY());
		for(int i=0; i<10; i++) {
			cord.transform(1, false);
			System.out.println(cord.getX() + "," + cord.getY());
		}
		*/
		System.out.println("Console ON");
		
		Controller controller = new Controller();
		controller.init();
		controller.setVisible(true);
		
	}
}
