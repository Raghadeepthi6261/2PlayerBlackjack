package blackjack;

import java.io.IOException;

public class GameLogic {

    Player dealer = null;
    Player player1 = null;
    Deck deck =  null;
    private final int BLACK_JACK_SCORE = 21;
    private final int MIN_WIN = 17;


    public GameLogic(Player player1,Player dealer,Deck deck) {
        this.player1=player1;
        this.dealer=dealer;
        this.deck = deck;
    }

    private Player firstRound() {

    	player1.drawCard(deck);
        dealer.drawCard(deck);
        player1.drawCard(deck);
        dealer.drawCard(deck);
        
        int playerScore = player1.getHandScore();
        int dealerScore = dealer.getHandScore();
        
        System.out.println("First Round Cards: "+dealer+" Total:"+dealerScore);
        System.out.println("First Round Cards: "+player1+" Total:"+playerScore);

        if(playerScore == BLACK_JACK_SCORE) {
        	 System.out.println("Player1 has won a BlackJack");
             return player1;
        } else if(dealerScore == BLACK_JACK_SCORE) {
        	System.out.println("Dealer has won a BlackJack");
            return dealer;
        }
        
        if(playerScore > BLACK_JACK_SCORE) {
        	System.out.println("Player1 has hand value grater than BlackJack. So DEALER Won");	
           return dealer;
        } else if (dealerScore > BLACK_JACK_SCORE) {
        	System.out.println("Dealer has hand value grater than BlackJack. So Player1 Won");
            return player1;
        }
        return null;
    }



    private Player secondRound() {
        
    	
        if (player1.hasEmptyHand()||dealer.hasEmptyHand()) {
            throw new IllegalStateException("You need to invoke round1 first");
        }

        while(player1.getHandScore() < MIN_WIN) {
        	player1.drawCard(deck);
        	System.out.println("Second Round Cards: "+player1+" Total:"+player1.getHandScore());
        }
        
        
        
        if (player1.getHandScore() > BLACK_JACK_SCORE) {
            System.out.println("Dealer Won because Player1 has value greater than BlackJack");
            return dealer;
        }

        while (player1.getHandScore() > dealer.getHandScore() && dealer.getHandScore() < MIN_WIN) {
        	dealer.drawCard(deck);
        	System.out.println("Second Round Cards: "+dealer+" Total:"+dealer.getHandScore());
        }

       

        if (dealer.getHandScore() > BLACK_JACK_SCORE) {
            System.out.println("Player1 Won because Dealer has value greater than BlackJack");
            return player1;
        }
        if (dealer.getHandScore() > player1.getHandScore()) {
            System.out.println("Dealer Won");
            return dealer;
        }
        else {
            System.out.println("Player1 Won");
            return player1;
        }
    }

    public Player play(Deck deck){
        Player winner = firstRound();
        if (winner!=null) {
            return winner;
        }
        return secondRound();
    }

	public static void main(String[] args) throws IOException{
    	Deck deck = null;
    	deck = Deck.getInstance();
    	Player dealer = new Player("Dealer");
        Player player1 = new Player("Player1");

        GameLogic gameLogic = new GameLogic(player1,dealer,deck);
        gameLogic.play(deck);
    }
}


