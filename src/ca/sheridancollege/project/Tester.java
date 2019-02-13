
package ca.sheridancollege.project;

import java.util.Scanner;
import java.util.ArrayList;

public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        
        TexasHoldem th1 = new TexasHoldem("game1");
                
        System.out.println("Enter Number of players: ");
        int numOfPlayers = kb.nextInt();
        ArrayList<Player> playerArr = new ArrayList<Player>();
        
        for (int i = 0; i < numOfPlayers; i++){
            System.out.println("Enter Player name: ");
            String name = kb.nextLine();
            System.out.println("Enter Player ID: ");
            String id = kb.nextLine();
            System.out.println("How much money they got?");
            double wallet = kb.nextDouble();
            playerArr.add(new TexasPlayer(name, id, wallet));
        }
        th1.setPlayers(playerArr);

        Deck d1 = new Deck(52);
        System.out.println(d1.toString());
        d1.shuffle();
        System.out.println(d1.toString());
        
        
    }
    
}
