package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;

public class SelectButton extends JButton implements ActionListener{
	private int type;
	private int data;
	private SelectPopUpFrame popupFrame;
	private StartFrame startFrame;
	//private Controller controller;
	private FinalFrame finalFrame;
	private Model model;
	
	
	public SelectButton(int type) {
		this.type = type;
		this.addActionListener(this);
	}
	
	public SelectButton(int data, int type) {
		this.setText(Integer.toString(data + 1));
		this.type = type;
		this.data = data;
		this.addActionListener(this);
	}
	
	public void setButton(SelectPopUpFrame popupFrame, Model model) {
		this.popupFrame = popupFrame;
		this.model = model;
	}
	
	public void setFinalFrame(FinalFrame finalFrame) {
		this.finalFrame = finalFrame;
	}
	
	public void setStartFrame(StartFrame startFrame) {
		this.startFrame = startFrame;
	}
	
	
	public int getType() {
		return this.type;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.type == 0) {
			startFrame.setNumOfPlayer(this.data + 1);
		}
		else if(this.type == 1){
			startFrame.setNumOfPiece(this.data + 1);
		}
		else if(this.type == 2) {
			model.getTurnPlayer().deleteDistance(data);
			model.turnCheck();
			popupFrame.dispose();
		}
		else if(this.type == 3) {
			startFrame.startGame();
		}
		else if(this.type == 4) {
			finalFrame.dispose();
			startFrame.getController().dispose();
			startFrame.startGame();
			/*
			startFrame.dispose();
			StartFrame newStartFrame = new StartFrame();
			newStartFrame.setVisible(true);
			*/
		}
		else if(this.type == 5) {
			System.exit(0);
		}

	}
}
