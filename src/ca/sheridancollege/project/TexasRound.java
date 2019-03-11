package ca.sheridancollege.project;

import java.util.ArrayList;

public class TexasRound {

    public static final double MINIMUM_BET = 0.25;
    public static final double SMALL_BLIND = 1;
    public static final double BIG_BLIND = 2;
    //number of items in playerPrompt
    public static final int MENU_ITEMS = 3;

    //private String roundName;
    //the total money on the table
    private double pot = 0;
    //the total a player must have bet during the round to stay in
    private double highestBet = 0;
    //keeps track of whos turn it is
    private int currentPlayer;
    //borrows players from games arraylist
    private ArrayList<TexasPlayer> texasPlayers;
    //false when the player can stay, true when they must see a raise
    public boolean mustSee = true;
    //true when no players must see to meet a raise, everyone has stayed
    public boolean allCall = false;

    public Deck deck;
    public Table table;

    public TexasRound(ArrayList<Player> players, int firstPlayer) {
        //setRoundName(name);
        for (int i = 0; i < players.size(); i++) {
            texasPlayers.add((TexasPlayer) players.get(i));
        }
        currentPlayer = firstPlayer;

        deck = new Deck(52);
        deck.shuffle();

        smallBlind(texasPlayers.get(currentPlayer));
        nextPlayer();
        bigBlind(texasPlayers.get(currentPlayer));
        nextPlayer();
        dealTable();
        dealTable();
        dealTable();

        while (allCall != true) {
            playerPrompt(mustSee, texasPlayers.get(currentPlayer));
            nextPlayer();
        }

        dealTable();
    }

    // getters and setters
//    public void setRoundName(String name) {
//        roundName = name;
//    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    //end of getters and setters

    public boolean bet(TexasPlayer player, double amount) {
        if (player.getWallet() >= amount) {
            player.walletUpdate(-1 * amount);
            player.roundBetUpdate(amount);
            pot += amount;
            return true;
        } else {
            return false;
        }
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
        for (int i = 0; i < texasPlayers.size(); i++) {//fix this, it is nearly duplicate
            (texasPlayers.get(i)).setCard1(deck.getCard());
            deck.removeCard();
        }
        for (int i = 0; i < texasPlayers.size(); i++) {//duplicate
            (texasPlayers.get(i)).setCard2(deck.getCard());
            deck.removeCard();
        }
    }

    public void dealTable() {
        table.setCard(deck.getCard());
        deck.removeCard();
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer <= texasPlayers.size() ? currentPlayer + 1 : 0;
    }

    public void playerPrompt(boolean see, TexasPlayer player) {
        String item1 = see == true ? "See" : "Stay";
        String menu = String.format("\n1.%s\n2.Raise\n3.Fold", item1);
        int menuItem = 0;

        while (menuItem < 1 || menuItem > MENU_ITEMS) {
            System.out.println(menu);
            menuItem = UserInput.getInt();
        }
        switch (menuItem) {
            case 1:
                see(player);
                break;
            case 2:
                raise(player);
                break;
            case 3:
                texasPlayers.remove(player);
                setCurrentPlayer(currentPlayer-=1);
                break;
            default:
            //throw()
        }
    }

    public void see(TexasPlayer player) {
        bet(player, (highestBet - player.getRoundBet()));
    }

    public void raise(TexasPlayer player) {
        see(player);
        System.out.println("\nRaise Amount: ");
        double amount = UserInput.getDouble();
        bet(player, amount);
    }
}
