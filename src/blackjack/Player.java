package blackjack;

public class Player {


    private String playerName =null;

    private Hand hand = new Hand();



    public Player(String playerName) {
        this.playerName=playerName;

    }

     public boolean hasEmptyHand() {
        return hand.empty();
    }

    public void drawCard(Deck deck) {
    	if(hand != null)
        hand.addCard(deck.draw());
    }


    public String getPlayerName(){
        return playerName;
    }
    
    public int getHandScore() {
    	return hand.getHandScore();
    }

    public String toString() {
        return playerName + ":" + " " + hand.toString(); 
    }

}

