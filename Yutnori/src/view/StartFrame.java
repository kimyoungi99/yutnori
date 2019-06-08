package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ListenerController;
import model.CONSTANT;
import model.Model;

public class StartFrame extends JFrame {
	Model model = new Model();
	private SelectButton[] playerSelectButton = new SelectButton[3];
	private SelectButton[] pieceSelectButton = new SelectButton[4];
	private SelectButton startButton = new SelectButton(3);
	private int numOfPlayer = 4;
	private int numOfPiece = 4;
	private MainFrame mainFrame;
	
	public StartFrame() {
		JPanel playerSelectionPanel = new JPanel();
		JPanel pieceSelectionPanel = new JPanel();
		JPanel startPanel = new JPanel();
		this.setBounds(150, 100, 300, 150);
		this.setLayout(new GridLayout(3, 0));
		playerSelectionPanel.setBounds(0, 0, 250, 50);
		playerSelectionPanel.setLayout(new GridLayout(0, 3));
		pieceSelectionPanel.setBounds(50, 0, 250, 50);
		pieceSelectionPanel.setLayout(new GridLayout(0, 4));
		startPanel.setBounds(100, 0, 250, 50);
		this.add(playerSelectionPanel);
		this.add(pieceSelectionPanel);
		this.add(startPanel);
		
		for(int i = 0; i < 3; i++) {
			this.playerSelectButton[i] = new SelectButton(i+1, 0);
			this.playerSelectButton[i].setStartFrame(this)
;			playerSelectionPanel.add(this.playerSelectButton[i]);
		}
		for(int i = 0; i < 4; i++) {
			this.pieceSelectButton[i] = new SelectButton(i+1, 1);
			this.pieceSelectButton[i].setStartFrame(this);
			pieceSelectionPanel.add(this.pieceSelectButton[i]);
		}
		startButton.setText("Start");
		startButton.setStartFrame(this);
		startPanel.add(startButton);
	}
	
	public static void main(String[] args) {
		StartFrame start = new StartFrame();
		start.setVisible(true);
	}
	
	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	public void setNumOfPiece(int numOfPiece) {
		this.numOfPiece = numOfPiece;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void startGame() {
		ConcreteObserver concreteObserver = new ConcreteObserver();
		MainFrame mainFrame = new MainFrame(numOfPlayer, numOfPiece, this);
		mainFrame.setStartFrame(this);
		mainFrame.init();
		concreteObserver.setMainFrame(mainFrame);
		for (int i = 0; i < CONSTANT.PLAYERNUM; i++) {
			model.getPlayer()[i].addObserver(concreteObserver);	
		}
		concreteObserver.updateBoard(model.getPlayer()[0].getYutnori().getBoard());
		ListenerController listenerController = new ListenerController(model, mainFrame);
		mainFrame.setVisible(true);
	}
		
}
