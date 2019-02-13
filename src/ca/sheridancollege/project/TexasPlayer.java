package ca.sheridancollege.project;

public class TexasPlayer extends Player{
    
    private double wallet;
    
    TexasPlayer(String name, String id, double wallet){
        super(name);
        super.setPlayerID(id);
        setWallet(wallet);
    }
    
    public void setWallet(double wallet){
        this.wallet = wallet;
    }
    
    public void walletUpdate (double amount){
        wallet += amount;
    }
    
    //abstracted method from parent class ///// fix it
    public void play(){
        System.out.println("I'm not sure what this is for yet");
    }

}
