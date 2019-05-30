package temp;

import java.util.Vector;

import model.Model;
import model.Player;

public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		Player player;
		Vector<Integer> result = new Vector<Integer>();
		boolean isCatch = false;
		
		while (!model.getGameEnd()) {
			player = model.getPlayer()[model.getTurn()];
			
			//윷 던지기 이벤트 발생
			result = player.throwYut();
			
			while(!result.isEmpty()) {
				//이동 가능 칸 계산 필요
				
				isCatch = false;
				
				//이동시킬 말, 이동할 칸 선택
				isCatch = player.movePiece(selectTile, targetTile);
				
				if(isPass) {
					player.setNumOfRestPiece(numOfPassPiece);
					if(player.getNumOfRestPiece() == 0) {
						model.setGameEnd();
						break;
					}
				}
				
				if(isCatch) {
					result.addAll(player.throwYut());
				}
				
				//움직인 distance를 result vector에서 빼주기 필요
			}
			
			result.clear();
			model.nextTurn();
		}
	}
}
