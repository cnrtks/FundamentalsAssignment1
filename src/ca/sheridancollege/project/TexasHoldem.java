package ca.sheridancollege.project;


public class TexasHoldem extends Game{
    
    int firstPlayer = 0;
    int rounds = 0;
    
    TexasHoldem(String givenName){
        super(givenName);
    }
    
    public int getFirstPlayer(){
        return firstPlayer;
    }
    
    public void setFirstPlayer(){
        firstPlayer = rounds % getPlayers().size();
    }
    
    //abstracted method from parent class ///// fix it
    public void play(){
        System.out.println("I'm not sure what this is for yet");
    }
    
    //abstracted method from parent class ///// fix it
    public void declareWinner(){
        System.out.println("Game Over");
    }

}
