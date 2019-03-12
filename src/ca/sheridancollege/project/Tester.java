
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Deck d1 = new Deck();
//        ArrayList<PlayingCard> deleteMe = new ArrayList();
//        for (int i = 0; i < 5; i++){
//            deleteMe.add((PlayingCard)d1.randCard());
//        }
//        HandValueChecker h1 = new HandValueChecker(deleteMe);
        
        TexasHoldem th1 = new TexasHoldem("game1");
                
        System.out.println("Enter Number of players: ");
        int numOfPlayers = TexasUserInput.getNumPlayers();
        ArrayList<Player> playerArr = new ArrayList<Player>();
        
        for (int i = 0; i < numOfPlayers; i++){
            System.out.println("Enter Player name: ");
            String name = UserInput.getString();
            System.out.println("Enter Player ID: ");
            String id = UserInput.getString();
            System.out.println("How much money they got?");
            double wallet = UserInput.getDouble();
            playerArr.add(new TexasPlayer(name, id, wallet));
        }
        th1.setPlayers(playerArr);
        
        TexasRound round1 = new TexasRound(playerArr, th1.getFirstPlayer());
        
        
    }
    
}
