package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExitButton extends JButton{
	private StartFrame sf;
	public ExitButton(StartFrame sf) {
		this.sf = sf;
	}

	public void addExitListener(ActionListener e) {
		this.addActionListener(e);
	}

}