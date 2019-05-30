package model;

import java.util.Random;

public class Yut {

	private boolean isBackDoYut;
	private boolean isFront; // 앞면이 평평한 부분

	public Yut(int yutType) {
		if (yutType == CONSTANT.YUTNUM - 1)
			this.isBackDoYut = true;
		else
			this.isBackDoYut = false;
	}

	public boolean getIsFront() {
		Random random = new Random();
		isFront = random.nextBoolean();
		return isFront;
	}

	public boolean getIsBackDo() {
		return isBackDoYut;
	}
}