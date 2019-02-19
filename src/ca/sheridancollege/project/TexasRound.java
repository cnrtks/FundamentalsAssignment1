package ca.sheridancollege.project;

public class TexasRound {
    
    public static final double MINIMUM_BET = 0.25;
    public static final double SMALL_BLIND = 1;
    public static final double BIG_BLIND = 2;
    
    //pot
    double pot = 0;
    
    public void bet(TexasPlayer player, double amount){
        player.walletUpdate(-1 * amount);
        pot += amount;
    }
    
    public void bigBlind(TexasPlayer player){
        bet(player, BIG_BLIND);
    }
    
    public void smallBlind(TexasPlayer player){
        bet(player, SMALL_BLIND);
    }
    
//    public void playerPrompts(){
//        
//    }
//    
//    public void gammePlay(){
//        
//    }
    
}
