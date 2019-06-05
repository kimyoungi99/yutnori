package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Cord;
import model.Model;

public class SelectPopUp extends JFrame{
	SelectButton[] select = new SelectButton[5];
	
	public SelectPopUp(int x, int y, Model model) {
		int minDis = 0;
		//this.model = model;
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 300, 300);
		this.setLayout(new GridLayout(0, 5));
		Cord temp = new Cord();
		//Cord temptemp = new Cord();
		temp.setCord(x, y);
		//temptemp.setCord(temp.getX(), temp.getY());
		while(temp.getX() != 999) {
			minDis++;
			temp.transform(1, true);
		}
		for(int i = 0; i < 5; i++) {
			if(i + 1 >= minDis && model.getTurnPlayer().isDistance(i + 1)) {
				select[i] = new SelectButton(i + 1, 2);
				select[i].setButton(this, model);
				select[i].setText(Integer.toString(i + 1));
				this.add(select[i]);
			}
		}
	}
}
