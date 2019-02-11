package ca.sheridancollege.project;

public enum Suit {

    CLUBS(1, "Clubs", '\u2663'),
    DIAMONDS(2, "Diamonds", '\u2662'),
    HEARTS(3, "Hearts", '\u2661'),
    SPADES(4, "Spades", '\u2660');

    private final int val;
    private final String name;
    private final char symbol;

    Suit(int val, String name, char symbol) {
        this.val = val;
        this.name = name;
        this.symbol = symbol;
    }
    
    public int getVal(){
        return val;
    }
    
    public String getName(){
        return name;
    }
    
    public char getSymbol(){
        return symbol;
    }
}
