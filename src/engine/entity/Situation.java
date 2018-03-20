package engine.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import engine.constant.Consts;
import engine.entity.card.Card;
import engine.entity.card.ServantCard;

public class Situation implements Cloneable{
	private int userId;
	//牌库
	private Queue<Card> library;
	//手牌
	private List<Card> hand;
	//战场上的牌
	private List<ServantCard> field;
	//坟地里的牌
	private List<Card> graveyard;
	//玩家水晶数量
	private int crystal;
	//玩家水晶上限
	private int crystalMax;
	//玩家血量
	private int health;
	//玩家疲劳值(牌库抽空之后再抽牌掉血,越掉越多)
	private int tiredness;
	
	public Situation(int userId){
		this.userId = userId;
		this.library = new LinkedList<Card>();
		this.hand = new ArrayList<Card>();
		this.field = new ArrayList<ServantCard>();
		this.graveyard = new ArrayList<Card>();
		this.crystalMax = 0;
		this.crystal = crystalMax;
		this.health = Consts.MAX_HEALTH;
		this.tiredness = 0;
	}
	
	@Override
	public Situation clone() throws CloneNotSupportedException {
		Situation newSituation = (Situation)super.clone();
		Queue<Card> newLibrary = new LinkedList<>();
		for (Card card : library) {
			newLibrary.add(card.clone());
		}
		newSituation.setLibrary(newLibrary);
		List<Card> newHand = new ArrayList<Card>();
		for (Card card : hand) {
			newHand.add(card.clone());
		}
		newSituation.setHand(newHand);
		List<ServantCard> newField = new ArrayList<ServantCard>();
		for (ServantCard card : field) {
			newField.add(card.clone());
		}
		newSituation.setField(newField);
		List<Card> newGrave = new ArrayList<Card>();
		for (Card card : graveyard) {
			newGrave.add(card.clone());
		}
		newSituation.setGraveyard(newGrave);
		return newSituation;
	}
	
	
	public Queue<Card> getLibrary() {
		return library;
	}
	public void setLibrary(Queue<Card> library) {
		this.library = library;
	}
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	public List<ServantCard> getField() {
		return field;
	}
	public void setField(List<ServantCard> field) {
		this.field = field;
	}
	public List<Card> getGraveyard() {
		return graveyard;
	}
	public void setGraveyard(List<Card> graveyard) {
		this.graveyard = graveyard;
	}
	public int getCrystal() {
		return crystal;
	}
	public void setCrystal(int crystal) {
		this.crystal = crystal;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}


	public int getTiredness() {
		return tiredness;
	}


	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}




	public int getCrystalMax() {
		return crystalMax;
	}




	public void setCrystalMax(int crystalMax) {
		this.crystalMax = crystalMax;
	}




	public int getUserId() {
		return userId;
	}
		
}
