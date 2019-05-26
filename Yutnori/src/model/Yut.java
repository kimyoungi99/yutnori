package model;
import java.util.Random;


public class Yut {
	
	private boolean isBackDo;
	private Random random = new Random();
	
	public Yut(int yutType) {
		if(yutType == 3)
			isBackDo = true;
		else
			isBackDo = false;
	}
	
	public boolean getRes() {
		return random.nextBoolean();
	}
	
	public boolean getIsBackDo() {
		return isBackDo;
	}
}