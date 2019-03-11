
package ca.sheridancollege.project;

public class Deck extends GroupOfCards{
    
    public Deck(){
        init();
    }
    
    private void init(){
        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                super.addCard(new PlayingCard(rank, suit));
            }
        }     
    }
    
    @Override
    public String toString(){
        String ret = "";
        for (int i = 0; i < super.getSize(); i ++){
            ret += showCards().get(i).toString();
            ret += "\n";
        }
        return ret;
    }
}
