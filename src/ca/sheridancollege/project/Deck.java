
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Deck extends GroupOfCards{
    
    public Deck(int size){
        super(size);
        init();
    }
    
    private void init(){
        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                super.addCard(new PlayingCard(rank, suit));
            }
        }     
    }
    
    public String toString(){
        String ret = "";
        for (int i = 0; i < getSize(); i ++){
            ret += showCards().get(i).toString();
            ret += "\n";
        }
        return ret;
    }
}
