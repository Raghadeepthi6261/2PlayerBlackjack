package blackjack;

public class Card {

	public enum Suit{
		CLUB("Club"), DIAMOND("Diamond"), HEART("Heart"), SPADE("Spade");
		private String suitChar;
		private Suit(String suitChar){
			this.suitChar = suitChar;
		}
	}
	
	public enum Face{
		ACE(11, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"),
		SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");
		private int value;
		private String key;
		private Face(int value, String key){
			this.value = value;
			this.key = key;
		}
	}
	Suit suit;
	Face face;
	
	public Card(Suit suit, Face face){
		this.suit = suit;
		this.face = face;
	}

	public int getValue(){
		return this.face.value;
	}
	
	public String toString()
    {
		 StringBuilder builder = new StringBuilder();
	        builder.append(face.key).append(" of ");
	        builder.append(suit.suitChar).append("s");
	        return builder.toString();
    }

}
