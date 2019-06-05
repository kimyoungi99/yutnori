package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.Model;

public class SelectButton extends JButton implements ActionListener{
	private int type;
	private SelectPopUp frame;
	private Model model;
	
	public SelectButton(int i, SelectPopUp frame, Model model) {
		this.model = model;
		this.setText(Integer.toString(i + 1));
		this.type = i;
		this.frame = frame;
		this.addActionListener(this);
	}
	
	public int getType() {
		return this.type;
	}
	
	public void actionPerformed(ActionEvent e) {
		model.getTurnPlayer().deleteDistance(type);
		frame.dispose();
	}
}
