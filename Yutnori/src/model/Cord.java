package model;

public class Cord {
	private int x;
	private int y;
	
	Cord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean transform(int delta, boolean start) {
		boolean is_done = false;
		
		if(delta == -1 && this.y == 0) {
			if(this.x == 1 && this.x == 2 && this.y == 3) {
				this.x--;
				this.y = 4;
			}
			else if(this.x == 4)
				this.x = 1;
			else if(this.x == 5)
				this.x= 2;
			else if(this.x == 0) {
				this.x = 3;
				this.y = 5;
			}
		}
		else {
			if(this.y == 0 && this.x == 0 && !start) {
				this.x = 999;
				this.y = 999;
				is_done = true;
			}
			else if(this.y == 0 && (this.x == 1 || this.y == 2)) {
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
						is_done = true;
					}
				}
			}
		}
		
		return is_done;
	}
}
