//The table object holds cards that are dealt to the entire table

package ca.sheridancollege.project;

import java.util.ArrayList;

public class Table {

    private ArrayList<Card> comCards = new ArrayList();

    public void setCard(Card card) {
        comCards.add(card);
    }
}
