import engine.HSGame;
import engine.constant.Target;
import engine.entity.Situation;
import engine.entity.card.Card;
import engine.entity.card.ServantCard;

public class Main {
	public static void main(String args[]){
		HSGame game = new HSGame();
		try {
			game.start(1, 2);
			Situation curUser;
			Situation oppUser;
			while(true){
				//手牌随从全上场
				curUser = game.getSituation()[0];
				for(int i=curUser.getHand().size(); i>=0; i--){
					game.useCard(1, i, Target.SELF_FIELD_RIGHT);
				}
				//场上随从全攻击，随机指定目标
				curUser = game.getSituation()[0];
				for(int i=curUser.getField().size()-1; i>=0; i--){
					oppUser = game.getSituation()[1];
					if(oppUser.getField().size()==0 || Math.random()>0.5)
						game.servantAttack(1, i, Target.OPPONENT);
					else{
						int targetIndex = (int)(Math.random() * oppUser.getField().size() + 10);
						game.servantAttack(1, i, Target.values()[targetIndex]);
					}
				}
				//打印战局，转到对手回合
				printTable(game.getSituation()[0], game.getSituation()[1]);
				game.endTurn(1);
				//手牌随从全上场
				curUser = game.getSituation()[0];
				for(int i=curUser.getHand().size(); i>=0; i--){
					game.useCard(2, i, Target.SELF_FIELD_RIGHT);
				}
				//场上随从全攻击，随机指定目标
				curUser = game.getSituation()[0];
				for(int i=curUser.getField().size()-1; i>=0; i--){
					oppUser = game.getSituation()[1];
					if(oppUser.getField().size()==0 || Math.random()>0.5)
						game.servantAttack(2, i, Target.OPPONENT);
					else{
						int targetIndex = (int)(Math.random() * oppUser.getField().size() + 10);
						game.servantAttack(2, i, Target.values()[targetIndex]);
					}
				}
				//打印战局，转到对手回合
				printTable(game.getSituation()[1], game.getSituation()[0]);
				game.endTurn(2);
			}
		} catch (Exception e) {
			printTable(game.getSituation()[0], game.getSituation()[1]);
			if (game.getWinnerId()>0)
				System.out.println("玩家"+game.getWinnerId()+"获胜！");
			e.printStackTrace();
		}
	}
	
	private static void printTable(Situation user1, Situation user2) {
		System.out.printf("user1血量：%d   水晶%d/%d\n",
				user1.getHealth(), user1.getCrystal(), user1.getCrystalMax());
		System.out.print("user1手牌：");
		for (Card card : user1.getHand()) {
			System.out.print(((ServantCard)card).toString() + "   ");
		}
		System.out.println();
		System.out.print("user1场面：");
		for (ServantCard card : user1.getField()) {
			System.out.print(card.toString() + "   ");
		}
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.print("user2场面：");
		for (ServantCard card : user2.getField()) {
			System.out.print(card.toString() + "   ");
		}
		System.out.println();
		System.out.print("user2手牌：");
		for (Card card : user2.getHand()) {
			System.out.print(((ServantCard)card).toString() + "   ");
		}
		System.out.println();
		System.out.printf("user2血量：%d   水晶%d/%d\n",
				user2.getHealth(), user2.getCrystal(), user2.getCrystalMax());
		System.out.println();
		System.out.println();
	}
	
}
