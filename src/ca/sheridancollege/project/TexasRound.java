package ca.sheridancollege.project;

import java.util.ArrayList;

public class TexasRound {

    public static final double MINIMUM_BET = 0.25;
    public static final double SMALL_BLIND = 1;
    public static final double BIG_BLIND = 2;

    //private String roundName;
    private double pot = 0;
    private boolean[] playerArr;
    private int currentPlayer;
    private ArrayList<Player> players;
    public Deck deck;

    public TexasRound(ArrayList<Player> players, int firstPlayer) {
        //setRoundName(name);
        playerArr = new boolean[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerArr[i] = true;
        }
        this.players = players;
        
        deck = new Deck(52);
        deck.shuffle();
    }

    // getters and setters
//    public void setRoundName(String name) {
//        roundName = name;
//    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    //end of getters and setters

    public void bet(TexasPlayer player, double amount) {
        player.walletUpdate(-1 * amount);
        pot += amount;
    }

    public void bigBlind(TexasPlayer player) {
        bet(player, BIG_BLIND);
    }

    public void smallBlind(TexasPlayer player) {
        bet(player, SMALL_BLIND);
    }

    public Card dealTopCard(Deck deck) {
        Card c = deck.getCard();
        deck.removeCard();
        return c;
    }

    public void dealFirstHand() {
        for (int i = 0; i < players.size(); i++) {//fix this, it is nearly duplicate
            ((TexasPlayer)players.get(i)).setCard1(deck.getCard());
            deck.removeCard();
        }
        for (int i = 0; i < players.size(); i++) {//duplicate
            players.get(i).setCard2(deck.getCard());
            deck.removeCard();
        }
    }
    
    
    
}
