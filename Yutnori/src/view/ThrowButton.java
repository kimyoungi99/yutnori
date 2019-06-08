package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ThrowButton extends JButton {

	public ThrowButton(int i) {
		if (i == 0)
			this.setText("RD");
		if (i == 1)
			this.setText("도");
		if (i == 2)
			this.setText("개");
		if (i == 3)
			this.setText("걸");
		if (i == 4)
			this.setText("윷");
		if (i == 5)
			this.setText("모");
		if (i == 6)
			this.setText("백");
		//addActionListener(this);
	}

	public void addThrowListener(ActionListener e) {
		this.addActionListener(e);
	}

	/*
	 * public void actionPerformed(ActionEvent e) {
	 * model.getTurnPlayer().throwYut(this.throwButtonID); }
	 */
}
