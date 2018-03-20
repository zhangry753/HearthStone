package engine.entity.card;

public class Card implements Cloneable{
	protected int id;  //卡牌id
	protected int cost;  //水晶消耗
	protected CardType cardType;  //卡牌类型
	
	public Card(){}
	public Card(int cost){
		this.cost = cost;
	}
	
	@Override
	public Card clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Card)super.clone();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCrystal() {
		return cost;
	}
	public void setCrystal(int crystal) {
		this.cost = crystal;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	

}
