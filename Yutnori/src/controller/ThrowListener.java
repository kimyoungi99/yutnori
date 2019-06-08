package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ThrowListener implements ActionListener{
	Model model;
	int type;
	
	public ThrowListener(Model model, int type) {
		this.type = type;
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(type);
		model.getTurnPlayer().throwYut(type);
    }
}
