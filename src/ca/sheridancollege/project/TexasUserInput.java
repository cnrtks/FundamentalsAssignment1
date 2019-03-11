package ca.sheridancollege.project;

import java.util.Scanner;

public class TexasUserInput extends UserInput {

    //min and max number of players for a game of texas holdem
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;
    //first and last options on players bet menu
    public static final int MENU_FLOOR = 1;
    public static final int MENU_ITEMS = 3;

    public static int getNumPlayers() {
        int ret;

        ret = getInt();
        if (ret < MIN_PLAYERS || ret > MAX_PLAYERS) {
            System.out.printf("\nMust be an integer between %d and %d", MIN_PLAYERS, MAX_PLAYERS);
            getNumPlayers();
        }
        return ret;
    }
    
        public static int getBetMenu() {
        int ret;

        ret = getInt();
        if (ret < MENU_FLOOR || ret > MENU_ITEMS) {
            System.out.printf("\nMust be an integer between %d and %d", MENU_FLOOR, MENU_ITEMS);
            getBetMenu();
        }
        return ret;
    }
        
        public static double getRaiseAmount(double maxRaise) {
            double ret;
            
            ret = getDouble();
            if (ret < 0 || ret > maxRaise){
                System.out.printf("\nRaise between $0 and $%.2f", maxRaise);
                getRaiseAmount(maxRaise);
            }
            return ret;
        }
}
