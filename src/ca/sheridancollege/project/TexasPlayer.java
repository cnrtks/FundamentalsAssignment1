package ca.sheridancollege.project;

public class TexasPlayer extends Player{
    
    private double wallet;
    private Card card1;
    private Card card2;
    
    TexasPlayer(String name, String id, double wallet){
        super(name);
        super.setPlayerID(id);
        setWallet(wallet);
    }
    
    //getters and setters
    public void setWallet(double wallet){
        this.wallet = wallet;
    }
    public void setCard1(Card card){
        card1 = card;
    }
    public void setCard2(Card card){
        card2 = card;
    }
    //end of getters and setters
    
    public void walletUpdate (double amount){
        wallet += amount;
    }
    
    //abstracted method from parent class ///// fix it
    public void play(){
        System.out.println("I'm not sure what this is for yet");
    }

}
