package ca.sheridancollege.project;

public enum Rank {

    ACE(1, "Ace", 'A'),
    TWO(2, "Two", '2'),
    THREE(3, "Three", '3'),
    FOUR(4, "Four", '4'),
    FIVE(5, "Five", '5'),
    SIX(6, "Six", '6'),
    SEVEN(7, "Seven", '7'),
    EIGHT(8, "Eight", '8'),
    NINE(9, "Nine", '9'),
    TEN(10, "Ten", '0'),
    JACK(11, "Jack", 'J'),
    QUEEN(12, "Queen", 'Q'),
    KING(13, "King", 'K');

    private final int val;
    private final String name;
    private final char symbol;

    Rank(int val, String name, char symbol) {
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
