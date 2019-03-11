//The table object holds cards that are dealt to the entire table

package ca.sheridancollege.project;

import java.util.ArrayList;

public class Table {

    private ArrayList<Card> comCards;
    
    public Table(){
        comCards = new ArrayList();
    }

    public void setCard(Card card) {
        comCards.add(card);
    }
    public String toString(){
        StringBuilder table = new StringBuilder("\n++++++++++++++++++++++++++++++++\n");
        for(int i = 0; i < comCards.size(); i++){
            table.append(comCards.get(i)).append("\n");
        }
        return table.append("++++++++++++++++++++++++++++++++").toString();
    }
}
