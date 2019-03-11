package ca.sheridancollege.project;

public class TexasOutput {

    public static String nextPlayerScreen(Player player) {
        return String.format("\n++++++++++++++++++++++++++++++++\n\n"
                + "%s"
                + "\nPress Enter\n"
                + "\n\n++++++++++++++++++++++++++++++++\n",
                player.getPlayerID());
    }
    
    public static String betMenuString(boolean see){
        String item1 = see ? "See" : "Stay";
        String menu = String.format("\n1.%s\n2.Raise\n3.Fold\n", item1);
        return menu;
    }
    
    public static String walletString(double amount){
        return String.format("Your Wallet: $%.2f", amount);
    }
    
    public static String toCallString(double amount){
        return String.format("To Call: $%.2f", amount);
    }
}
