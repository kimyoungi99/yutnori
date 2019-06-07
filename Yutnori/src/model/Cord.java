package model;

public class Cord {
	private int x;
	private int y;
	
	public void setCord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void transform(int delta, boolean start) {
		//boolean is_done = false;
		
		if(delta == -1 && this.y == 0) {
			if(this.x == 1 || this.x == 2 || this.x == 3) {
				this.x--;
				this.y = 4;
			}
			else if(this.x == 4)
				this.x = 1;
			else if(this.x == 5)
				this.x= 2;
			else if(this.x == 0) {
				this.x = 3;
				this.y = 4;
			}
		}
		else {
			if(!start) {
				if(delta == 5)
					this.setCord(1, 0);
				else
					this.y = delta;
			}
			else if(this.y == 0 && this.x == 0) {
				this.x = 999;
				this.y = 999;
				//is_done = true;
			}
			else if(this.y == 0 && (this.x == 1 || this.x == 2)) {
				this.x += 3;
				this.y = delta - 1;
			}
			else if(this.y + delta < 5)
				this.y += delta;
			else {
				if(this.x == 1 || this.x == 2 || this.x == 0) {
					this.y = (this.y + delta) % 5;
					this.x++;
				}
				else if(this.x == 4) {
					this.y = (this.y + delta) % 5;
					this.x = 3;
				}
				else {
					if(this.y + delta == 5) {
						this.x = 0;
						this.y = 0;
					}
					else {
						this.x = 999;
						this.y = 999;
						//is_done = true;
					}
				}
			}
		}
		if(this.x == 4 && this.y == 2)
			this.x = 5;
	}
	
	public int distance(Cord target) {
		int res;
		if((this.x == 1 && target.x == 0)||(this.x == 2 && target.x == 1)||(this.x == 3 && target.x == 2)||(this.x == 3 && target.x == 4)||(this.x == 0 && target.x == 5)||(this.x == 0 && target.x == 3))
			res = 5 - target.y + this.y;
		else if(this.x == target.x || this.x == 5 && target.x == 4)
			res = this.y - target.y;
		else if((this.x == 3 && target.x == 0)||(this.x == 2 && target.x == 3)||(this.x == 1 && target.x == 2)||(this.x == 0 && target.x == 1)||(this.x == 1 && target.x == 4)||(this.x == 2 && target.x == 5))
			res = -1;
		else if(this.x != target.x)
			res = this.y - target.y + 1;
		else
			res = this.y + 1;
		return res;
	}
}
