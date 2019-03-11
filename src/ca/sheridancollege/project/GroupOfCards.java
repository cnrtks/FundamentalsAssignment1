/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    
    public GroupOfCards(){
        cards = new ArrayList();
    }
    
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }
    
    public void addCard(Card c){
        cards.add(c);
    }
    
    public int getSize(){
        return cards.size();
    }
    //returns last card by default
    public Card getCard(){
        return cards.get(cards.size()-1);
    }
    //returns card at index number
    public Card getCard(int index){
        return cards.get(index);
    }
    //removes last card from arraylist
    public void removeCard(){
        cards.remove(cards.size() - 1);
    }
    //removes card at index
    public void removeCard(int index){
        cards.remove(index);
    }
    
    public void clearGroupOfCards(){
        cards.clear();
    }
        
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    //returns a random card
    public Card pickCard(){
        int randC = (int)(Math.floor(Math.random()* cards.size()));
        return cards.get(randC);
    }
    
}//end class
