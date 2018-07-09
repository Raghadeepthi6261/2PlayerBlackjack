package blackjack;

import java.util.ArrayList;
import java.util.List;


public class Hand {

    private List<Card> hand = new ArrayList<>();


    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandScore(){
    	int total =0;
    	for(int i=0 ;i < hand.size() ;i++) {
    		total = total+ hand.get(i).getValue();
    		
    	}	
    	return total;
    }

    public boolean empty() {
        return hand.size()==0;
    }

    public String toString() {
    	String toString = hand.toString();
        return toString;
    }

	
}
