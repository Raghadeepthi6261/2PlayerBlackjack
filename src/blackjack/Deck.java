package blackjack;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import blackjack.Card.Face;
import blackjack.Card.Suit;

public class Deck {
	
	private static Deck obj;
	private Stack<Card> cards = new Stack<>();

	public static Deck getInstance(){
		if(obj == null){
			obj = new Deck();
		}
		return obj;
	}
	
	private Deck(){
		fillDeckWithAllCards();
	}
	
	public void fromFile(File file) throws IOException {
            Scanner scanner=null;
            try {
                scanner = new Scanner(file);
                for (String card : scanner.nextLine().split(", ")) {
                   for(Card.Suit suit: Card.Suit.values()){
                		if(card.substring(1).equalsIgnoreCase(suit.toString())) {
                			cards.push(new Card(Enum.valueOf(Suit.class, card.substring(1, card.length()).toString()),
                					Enum.valueOf(Face.class, card.substring(0, 1).toString())));
                		}
                		else if(card.substring(2).equalsIgnoreCase(suit.toString())) {
                			cards.push(new Card(Enum.valueOf(Suit.class, card.substring(2, card.length()).toString()),
                					Enum.valueOf(Face.class, card.substring(0, 2).toString())));
                		}
                	}
                }


            } finally {
                if (scanner!=null) {
                    scanner.close();
                }
            }
          
	}


	
    public Card draw() {
        if (cards.isEmpty()) {
            fillDeckWithAllCards();
        }
        return cards.pop();
    }

    public Card peek() {
        if (cards.isEmpty()) {
            fillDeckWithAllCards();
        }
        return cards.peek();
    }

    private void fillDeckWithAllCards() {
    	for(Card.Suit suit: Card.Suit.values()){
			for(Card.Face face: Card.Face.values()){
                cards.push(new Card(suit, face));
             }
        }
        shuffle();
    }

    private void shuffle() {
       Collections.shuffle(cards);
    }

}