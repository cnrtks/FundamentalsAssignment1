package ca.sheridancollege.project;

import java.util.ArrayList;

//takes 7 card hands and creates every possible 5 hand combo
//not optimized for any other numbers ////////////////////////////VARIABLE SCOPE
public class BestHandChecker {

    public static final int REAL_HAND = 5;
    public static final int GIVEN_HAND = 7;

    private ArrayList<PlayingCard> tempHand5;
    private ArrayList<PlayingCard> tempHand7;
    private ArrayList<PlayingCard> bestHand;

    BestHandChecker(ArrayList<PlayingCard> givenHand) {
        tempHand7 = new ArrayList();
        tempHand7.addAll(givenHand);
        
        int x = 5;
        int y = 7;     

        for (int k = 0; k < REAL_HAND; k++) {
            for (int i = 0; i < REAL_HAND; i++) {
                tempHand5.add(tempHand7.get(i));
            }
            moveCard(tempHand5,  GIVEN_HAND - 1, 0);
            for (int j = 0; j < GIVEN_HAND - k; j++) {
                moveCard(tempHand5, REAL_HAND, k);
                for (int i = 0; i < REAL_HAND; i++) {
                    tempHand5.add(tempHand7.get(i));
                }
            }
        }

    }
    public void moveCard (ArrayList arr, int moveFrom, int moveTo){
        arr.add(moveTo, arr.get(moveFrom));
        moveFrom = moveFrom > moveTo ? moveFrom++ : moveTo;
        arr.remove(moveFrom);
    }
}
/////
//move 6 to one x 5
//move 7 to one x 1
//move move 6 to 2 x 4
//move7 to one x1
//move 6 to 3 x3
//move 7 to 1 x1
//move 6 to 4 x2
//move 7 to 1 x 1
//move 6 to 5 x 1
//move 7 to 1x1
