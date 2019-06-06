package model;

public class ClickData {
	//0: 윷 던지기 전, 1: 윷 던지고 움직일 말 선택전, 2: 움직일 말로 출발 말 선택, 3: 움직일 말로 기존 판 위의 말 선택
	private int status = 0;
	private int selectedX = 0;
	private int selectedY = 0;
	
	public int getStatus() {
		return status;
	}
	
	public int getSelectedX() {
		return selectedX;
	}
	
	public int getSelectedY() {
		return selectedY;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setXY(int x, int y) {
		this.selectedX = x;
		this.selectedY = y;
	}
	
	public void setClickData(int status, int x, int y) {
		this.status = status;
		this.selectedX = x;
		this.selectedY = y;
	}
}
