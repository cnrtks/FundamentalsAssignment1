package ca.sheridancollege.project;

import java.util.ArrayList;

public class TexasRound {

    public static final double MINIMUM_BET = 0.25;
    public static final double SMALL_BLIND = 1;
    public static final double BIG_BLIND = 2;
    //number of items in playerPrompt
    public static final int MENU_ITEMS = 3;

    //private String roundName;
    private double pot = 0;
    //array for player during round [true=hasnt folded]
    private boolean[] playerArr;
    //keeps track of whos turn it is
    private int currentPlayer;
    //borrows players from games arraylist
    private ArrayList<Player> players;
    //false whne the player can stay true when they must see a raise
    public boolean mustSee = true;
    //true when no players must see to meet a raise, everyone has stayed
    public boolean allCall = false;

    public Deck deck;
    public Table table;

    public TexasRound(ArrayList<Player> players, int firstPlayer) {
        //setRoundName(name);
        this.players = players;
        currentPlayer = firstPlayer;

        deck = new Deck(52);
        deck.shuffle();

        smallBlind((TexasPlayer) players.get(currentPlayer));
        nextPlayer();
        bigBlind((TexasPlayer) players.get(currentPlayer));
        nextPlayer();
        dealTable();
        dealTable();
        dealTable();

        while (allCall != true) {
            playerPrompt(mustSee, currentPlayer);
            nextPlayer();
        }

        dealTable();

        while (allCall != true) {
            playerPrompt(mustSee, currentPlayer);
            nextPlayer();
        }
        dealTable();

        while (allCall != true) {
            playerPrompt(mustSee, currentPlayer);
            nextPlayer();
        }
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
            ((TexasPlayer) players.get(i)).setCard1(deck.getCard());
            deck.removeCard();
        }
        for (int i = 0; i < players.size(); i++) {//duplicate
            ((TexasPlayer) players.get(i)).setCard2(deck.getCard());
            deck.removeCard();
        }
    }

    public void dealTable() {
        table.setCard(deck.getCard());
        deck.removeCard();
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer <= players.size() ? currentPlayer + 1 : 0;
    }
    
    public void playerPrompt(boolean see, int player){
           String item1 = see == true ? "See" : "Stay";
           String menu = String.format("1.%s\n2.Raise\n3.Fold", item1);
           int menuItem = 0;
           
           while (menuItem < 1 || menuItem > MENU_ITEMS){
               System.out.println(menu);
               //get input
           }
           switch(menuItem){
               case 1: see();
               break;
               case 2: raise();
               break;
               case 3: fold();
               break;
               default:
                   //throw()
           }
}

}
