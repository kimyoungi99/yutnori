package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.Model;

public class SelectButton extends JButton implements ActionListener{
	private int type;
	private int data;
	private SelectPopUp frame;
	private StartFrame startFrame;
	private Model model;
	
	public SelectButton(int data, int type) {
		this.setText(Integer.toString(data + 1));
		this.type = type;
		this.data = data;
		this.addActionListener(this);
	}
	
	public void setButton(SelectPopUp frame, Model model) {
		this.frame = frame;
		this.model = model;
	}
	
	public void setSB(StartFrame startFrame) {
		this.startFrame = startFrame;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.type == 2) {
			model.getTurnPlayer().deleteDistance(type);
			frame.dispose();
		}
		else if(this.type == 0) {
			startFrame.setNumOfPlayer(this.data + 1);
		}
		else {
			startFrame.startGame(this.data + 1);
		}
	}
}
