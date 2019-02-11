
package ca.sheridancollege.project;


public class PlayingCard extends Card{
    
    private Rank rank;
    private Suit suit;
    
    PlayingCard(){
        rank = Rank.ACE;
        suit = Suit.SPADES;
    };
    
    PlayingCard(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    };
    
    public void setRank(Rank rank){
        this.rank = rank;
    };
    
    public Rank getRank(){
        return rank;
    };
    
    public void setSuit(Suit suit){
        this.suit = suit;
    };
    
    public Suit getSuit(){
        return suit;
    };
    
    public String toString(){
        return String.format("%s of %s", rank.getName(), suit.getName());
    };
    
    public String shortString(){
        return "" + rank.getSymbol() + suit.getSymbol();
    };
}
