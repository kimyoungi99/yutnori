package controller;

import model.CONSTANT;
import model.Model;
import view.MainFrame;

public class ListenerController {
	
	public ListenerController(Model model, MainFrame mainFrame) {
		
		for(int i=0; i<mainFrame.getThrowButton().length; i++) {
			mainFrame.getThrowButton()[i].addThrowListener(new ThrowListener(model, i));
		}
		
		for(int i=0; i<CONSTANT.PLAYERNUM; i++) {
			for(int j=0; j<CONSTANT.PIECENUM; j++) {
				mainFrame.getRestPieceButton()[i][j].addRestPieceListener(new RestPieceListener(model, i, j));
			}
		}
		
		for(int i=0; i<mainFrame.getGameBoardPanel().getTileButton().length; i++) {
			for(int j=0; j<mainFrame.getGameBoardPanel().getTileButton()[0].length; j++) {
				mainFrame.getGameBoardPanel().getTileButton()[i][j].addTileListener(new TileListener(model, i, j));
			}
		}
		
		//mainFrame.getGameBoardPanel().getExitButton().addExitListener(new ExitListener(model), mainFrame.getStartFrame());
		mainFrame.getGameBoardPanel().getExitButton().addExitListener(new ExitListener(model));
	}

}
