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

    public static int HAND_SIZE = 5;

    private ArrayList<PlayingCard> hand7;
    private ArrayList<PlayingCard> hand5;
    private int handValue = 0;
    private PlayingCard kicker;
    boolean flush;
    boolean straight;

    public HandValueChecker(ArrayList<PlayingCard> givenHand) {
        hand7 = new ArrayList();
        hand7.addAll(givenHand);
        Collections.sort(hand7);
        for (PlayingCard a : hand7) {
            System.out.println(a.toString());
        }
        handValue = matchCheck();
       if (handValue > 1) {
            straight = false;
            flush = false;
        } else {
            straight = straightCheck();
            flush = flushCheck();
        }
        handValue = (flush && straight) ? (hand5.get(0).getRank().getVal() == 10 ? 9 : 10) : handValue;

    }

    public int getHandValue() {
        return handValue;
    }

    public PlayingCard getKicker() {
        return kicker;
    }

    public boolean flushCheck() {
        int[] suits = new int[4];//clubs, diamonds, hearts, spades
        for (PlayingCard c : hand7) {
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

    public boolean straightCheck() {
        ArrayList<PlayingCard> tempHand5 = new ArrayList();
        Collections.reverse(hand7);

        for (PlayingCard c : hand7) {
            for (int i = 0; i < 5; i++) {
                for (PlayingCard d : hand7) {
                    if (c.getRank().getVal() - i == d.getRank().getVal()) {
                        try {
                            if (tempHand5.get(i).getSuit().getVal() != d.getSuit().getVal()) {
                                tempHand5.remove(i);
                                tempHand5.add(d);
                            }
                        } catch (Exception e) {
                            tempHand5.add(d);
                        }
                    }
                    if (c.getRank().getVal() == 5) {
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
                    if (tempHand5.size() == 5) {
                        if (handValue < 5) {
                            hand5.addAll(tempHand5);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //this should always return a value of 1,2,3,4,7, or 8 any other value is an error
    public int matchCheck() {
        ArrayList<PlayingCard> tempHighestMatches = new ArrayList();
        ArrayList<PlayingCard> highestMatches = new ArrayList();
        ArrayList<PlayingCard> lowPair = new ArrayList();
        ArrayList<PlayingCard> highestPair = new ArrayList();
        ArrayList<PlayingCard> tempHand5 = new ArrayList();
        ArrayList<PlayingCard> highestSingles = new ArrayList();
        int pair = 0;
        int highest = 0;
        int ret = 0;
        PlayingCard kickerTemp = hand7.get(0);
        for (PlayingCard c1 : hand7) {
            tempHighestMatches.removeAll(tempHighestMatches);
            int matches = 0;
            for (PlayingCard c2 : hand7) {
                if (c1.getRank().getVal() == c2.getRank().getVal()) {
                    matches++;
                    tempHighestMatches.add(c1);
                } else {
                    if (c2.getRank().getVal() > kickerTemp.getRank().getVal()) {
                        kickerTemp = c2;
                    } else {
                        highestSingles.add(0, c2);
                    }
                }
            }
            if (matches == 2) {
                pair++;
                if (!highestPair.isEmpty()) {
                    lowPair.addAll(highestPair);
                }
                highestPair.removeAll(highestPair);
                highestPair.addAll(tempHighestMatches);
            }
            if (matches >= highest) {
                highestMatches.removeAll(highestMatches);
                highestMatches.addAll(tempHighestMatches);
                highest = matches;
            }
            highest = matches > highest ? highest : matches;
        }
        //2 pair
        if (pair > 1) {
            ret = 3;
            tempHand5.addAll(highestPair);
            tempHand5.addAll(lowPair);
            tempHand5.add(kickerTemp);
        } //3 of a kind and fullhouse
        else if (highest == 3) {
            tempHand5.addAll(tempHighestMatches);
            if (pair > 0) {
                tempHand5.addAll(highestPair);
                ret = 7;
            } else {
                ret = 4;
            }
            tempHand5.add(kickerTemp);

        } //highcard pair or four of a kind
        else {
            ret = highest > 3 ? 8 : highest;
            tempHand5.addAll(tempHighestMatches);
            tempHand5.add(kicker);
        }

        int i = 0;
        while (tempHand5.size() < 5) {
            tempHand5.add(highestSingles.get(i));
            i++;
        }
        kicker = kickerTemp;
        hand5.addAll(tempHand5);
        return ret;
    }
}
