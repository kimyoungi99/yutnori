package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;

public class GameInfoPanel extends JPanel{
	private JLabel turnLabel = new JLabel();
	private JLabel throwChanceLabel = new JLabel();
	private JLabel textLabel = new JLabel();
	private ImageIcon defaultImage[] = new ImageIcon[4];
	
	public GameInfoPanel() {
		int startPixel = 140;
		this.setLayout(null);
		for(int i=0; i<defaultImage.length; i++) {
			String address = "src/view/img/";
			address = address + Integer.toString(i+1) + "-1.png";
			defaultImage[i] = new ImageIcon(address);
		}
		turnLabel.setIcon(defaultImage[0]);
		turnLabel.setBounds(startPixel, 5, 54, 54);
		
		textLabel.setText("님의 남은 윷 던지기 기회: ");
		throwChanceLabel.setText("1");
		
		textLabel.setBounds(startPixel + 65, 5, 300, 54);
		textLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		throwChanceLabel.setBounds(startPixel + 300, 5, 54, 54);
		throwChanceLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		this.add(turnLabel);
		this.add(textLabel);
		this.add(throwChanceLabel);
	}
	
	public JLabel getThrowChanceLabel() {
		return throwChanceLabel;
	}
	
	public JLabel getTurnLabel() {
		return turnLabel;
	}
}
