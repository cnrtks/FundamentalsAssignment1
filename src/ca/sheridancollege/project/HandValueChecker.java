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
public class HandValueChecker {

    public static final int HAND_SIZE = 5;

    private ArrayList<PlayingCard> hand7;
    private ArrayList<PlayingCard> hand5;
    private int handValue = 0;
    boolean flush;
    boolean straight;

    public HandValueChecker(ArrayList<PlayingCard> givenHand) {
        hand7 = new ArrayList();
        hand5 = new ArrayList();
        hand7.addAll(givenHand);
        Collections.sort(hand7);
        Collections.reverse(hand7);
        handValue = matchCheck();
        //any matches higher than 3 of a kind will preclude the possibility of a straight or flush in 7 card hand
        if (handValue > 4) { //for given hand greater than 7 just remove this if
            straight = false;
            flush = false;
        } else {
            straight = straightCheck();
            if (handValue < 6) {
                flush = flushCheck(hand7);
            }
        }
        //for debug
        System.out.println(hand5);
        //remove above
        System.out.println(handValue);
//        return handValue;
    }

    public int getHandValue() {
        return handValue;
    }

    public boolean straightCheck() {
        ArrayList<PlayingCard> tempHand5 = new ArrayList();
        ArrayList<PlayingCard> high5 = new ArrayList();

        for (int i = 0; i < hand7.size() - HAND_SIZE; i++) {
            tempHand5.clear();
            tempHand5.add(hand7.get(i));
            for (int j = 1; j < HAND_SIZE; j++) {
                for (PlayingCard d : hand7) {
                    if (hand7.get(i).getRank().getVal() - j == d.getRank().getVal()) {
                        try {
                            if (tempHand5.get(j).getSuit().getVal() != d.getSuit().getVal()) {
                                tempHand5.remove(j);
                                tempHand5.add(d);
                            }
                        } catch (Exception e) {
                            tempHand5.add(d);
                        }
                    }
                    if (hand7.get(i).getRank().getVal() == 5) {
                        if (d.getRank().getVal() == 14) {
                            try {
                                if (tempHand5.get(4).getSuit().getVal() != d.getSuit().getVal()) {
                                    tempHand5.remove(4);
                                    tempHand5.add(d);
                                }
                            } catch (Exception e) {
                                tempHand5.add(d);
                            }
                        }
                    }
                    //checks for straight flush and royal flush
                    //keeps straight in high5 in case lower card value straight is straight flush
                    if (tempHand5.size() == 5) {
                        if (flushCheck(tempHand5)) {
                            handValue = tempHand5.get(0).getRank().getVal() == 10 ? 9 : 10;
                            hand5 = tempHand5;
                            return true;
                        } else if (high5.isEmpty()) {
                            high5.addAll(tempHand5);
                        }
                    }
                }
            }
        }
        if (!high5.isEmpty() && handValue < 5) {
            hand5.clear();
            hand5.addAll(high5);
            handValue = 5;
        }
        return false;
    }

    public boolean flushCheck(ArrayList<PlayingCard> givenHand) {
        int[] suits = new int[5];//clubs, diamonds, hearts, spades
        for (PlayingCard c : givenHand) {
            suits[c.getSuit().getVal()]++;
            if (suits[c.getSuit().getVal()] >= 5) {
                if (handValue < 6) {
                    handValue = 6;
                    for (PlayingCard d : hand7) {
                        if (d.getSuit().getVal() == suits[c.getSuit().getVal()]) {
                            hand5.add(d);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    //this should always return a value of 1,2,3,4,7, or 8 any other value is an error
    public int matchCheck() {
        ArrayList<PlayingCard> persistentHand7 = new ArrayList();
        ArrayList<PlayingCard> tempHand7 = new ArrayList();
        ArrayList<PlayingCard> tempHighestMatches = new ArrayList();
        ArrayList<PlayingCard> highestMatches = new ArrayList();
        ArrayList<PlayingCard> highestPair = new ArrayList();
        ArrayList<PlayingCard> lowPair = new ArrayList();
        ArrayList<PlayingCard> tempHand5 = new ArrayList();

        int pair = 0;
        int highest = 0;
        int ret = 0;

        persistentHand7.addAll(hand7);
        tempHand7.addAll(hand7);

        for (PlayingCard c1 : persistentHand7) {
            tempHighestMatches.clear();
            int matches = 1;
            tempHighestMatches.add(c1);
            tempHand7.remove(c1);
            for (PlayingCard c2 : tempHand7) {
                if (c1.getRank().getVal() == c2.getRank().getVal()) {
                    matches++;
                    tempHighestMatches.add(c2);
                }
            }
            if (matches == 2) {
                pair++;
                highest = matches > highest ? matches : highest;
                if (pair == 1) {
                    highestPair.addAll(tempHighestMatches);
                }
                if (pair == 2) {
                    lowPair.addAll(tempHighestMatches);
                }
            } else if (matches > highest) {
                highestMatches.clear();
                highestMatches.addAll(tempHighestMatches);
                highest = matches;
            }
            tempHand7.removeAll(tempHighestMatches);
        }

        //2 pair
        if (pair > 1 && highest == 2) {
            ret = 3;
            tempHand5.addAll(highestPair);
            tempHand5.addAll(lowPair);
        } //3 of a kind and fullhouse
        else if (highest == 3) {
            tempHand5.addAll(highestMatches);
            if (pair > 0) {
                tempHand5.addAll(highestPair);
                ret = 7;
            } else {
                ret = 4;
            }
        } //highcard pair or four of a kind
        else {                                  //split up if given hand is greater than 7
            ret = highest > 3 ? 8 : highest;
            tempHand5.addAll(highestMatches);
        }

        //used to fill hand to 5 and get highest kicker if needed
        int i = 0;
        persistentHand7.removeAll(tempHand5);
        while (tempHand5.size() < HAND_SIZE) {
            tempHand5.add(persistentHand7.get(i));
            i++;
        }

        hand5.addAll(tempHand5);

        return ret;
    }

    public String toString() {
        String out = "";
        for (PlayingCard c : hand5) {
            out += c.shortString();
            out += "";
        }
        return out;
    }
}
