package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

//Highcard
//Pair
//Two Pair
//Three Of Kind
//Straight
//Flush
//Full House
//Four Of A Kind
//Straight Flush
//Royal Flush

//can only handle hands of 5 cards
public class HandValueChecker {

    public static int HAND_SIZE = 5;

    private ArrayList<PlayingCard> hand;
    private int handValue = 0;
    private PlayingCard kicker;
    boolean flush;
    int straightLow;

    public HandValueChecker(ArrayList<PlayingCard> givenHand) {
        hand = new ArrayList();
        hand.addAll(givenHand);
        Collections.sort(hand);
        for (PlayingCard a : hand) {
            System.out.println(a.toString());
        }
        handValue = matchCheck();
        if (handValue > 1){
            straightLow = 0;
            flush = false;
        }
        else{            
            straightLow = straightCheck();
            flush = flushCheck();
        }
        handValue = handValue < 5 && straightLow != 0 ? 5 : handValue;
        handValue = handValue < 6 && flush ? 6 : handValue;
        handValue = flush && straightLow !=0 ?
                (hand.get(0).getRank().getVal() == 10 ? 9 : 10) : handValue;
        
    }

    public int getHandValue(){
        return handValue;
    }
    
    public PlayingCard getKicker(){
        return kicker;
    }
    
    public boolean flushCheck() {
        Suit s = hand.get(0).getSuit();
        if (!hand.stream().noneMatch((c) -> (s != c.getSuit()))) { //functional operator READ UP ON THIS
            return false;
        }
        return true;
    }

    public int straightCheck() {
        int val = hand.get(0).getRank().getVal();
        int consecutive = 0;
        //for aces low
        if (hand.get(4).getRank().getVal() == 14) {
            val = 1;
            for (int i = 0; 1 < HAND_SIZE - 1; i++) {
                consecutive = val + i + 1 == hand.get(i).getRank().getVal() ? consecutive++ : consecutive;
            }
        //for aces high
        } else {
            for (int i = 1; i < HAND_SIZE; i++) {
                consecutive = val + i == hand.get(i).getRank().getVal() ? consecutive++ : consecutive;
            }
        }
        return consecutive == HAND_SIZE - 1 ? val : 0;
    }
    
    //this should always return a value of 1,2,3,4,7, or 8 any other value is an error
    public int matchCheck() {
        int pair = 0;
        int highest = 0;
        int ret = 0;
        PlayingCard kickerTemp = hand.get(0);
        for (PlayingCard c1 : hand) {
            int matches = 0;
            for (PlayingCard c2 : hand) {
                if (c1.getRank().getVal() == c2.getRank().getVal()) {
                    matches++;
                }
                else{
                    kickerTemp = (c2.getRank().getVal() > kickerTemp.getRank().getVal()) ?
                            c2 : kickerTemp;
                }
            }
            pair = matches == 2 ? pair : pair++;
            if (matches > highest){
                highest = matches;
            }
            highest = matches > highest ? highest : matches;
        }

        //2 pair
        if (pair == 2){
            ret = 3;
        }
        //3 of a kind and fullhouse
        else if(highest == 3){
            ret = pair > 0 ? 7 : 4;
        }
        //highcard pair or four of a kind
        else{
        ret = highest > 3 ? 8 : highest;    
        }
        
        kicker = kickerTemp;
        return ret;
    }
}

////checks variable length hands as HAND_SIZE (5) card hands
////iterates 5 card hands from lowest to highest
////takes lowest card and compares it with following 4 cards
//// if they are consecutive == 5 returns lowest cards value
////else returns 0
////this function fails when presented with same value cards please fix
//    public int straightCheck() { //dont use me
//        int ret = 0;
//        for (int i = 0; i <= (hand.size() - HAND_SIZE); i++) {
//            int val = hand.get(i).getRank().getVal();
//            int consecutive = 0;
//            for (int j = 0; j < HAND_SIZE; j++) {
//                if (hand.get(i + j + 1).getRank().getVal() == val + i + j + 1) {
//                    consecutive++;
//                }
//                if (consecutive == HAND_SIZE) {
//                    ret = val;
//                }
//            }
//        }
//        return ret;
//    }
//}
