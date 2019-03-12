package ca.sheridancollege.project;

public class TexasPlayer extends Player{
    
    private double wallet;
    private double roundBet = 0;
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
    public double getWallet(){
        return wallet;
    }
    public void setCard1(Card card){
        card1 = card;
    }
    public Card getCard1(){
        return card1;
    }
    public void setCard2(Card card){
        card2 = card;
    }
    public Card getCard2(){
        return card2;
    }
    public double getRoundBet(){
        return roundBet;
    }
    //end of getters and setters

    public void walletUpdate(double amount){
        wallet += amount;
    }
    
    public void roundBetUpdate(double amount){
        roundBet += amount;
    }
    
    //abstracted method from parent class ///// fix it
    public void play(){
        System.out.println("I'm not sure what this is for yet");
    }

}
