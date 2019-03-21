package ca.sheridancollege.project;

import java.util.ArrayList;

public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //randomcards
//        Deck d1 = new Deck();
//        ArrayList<PlayingCard> deleteMe = new ArrayList();
//        for (int i = 0; i < 7; i++) {
//            deleteMe.add((PlayingCard) d1.randCard());
//        }
//        
//        HandValueChecker h1 = new HandValueChecker(deleteMe);

        //hand tester
        PlayingCard s3 = new PlayingCard(Rank.THREE, Suit.SPADES);
        PlayingCard d3 = new PlayingCard(Rank.THREE, Suit.DIAMONDS);
        PlayingCard s4 = new PlayingCard(Rank.FOUR, Suit.SPADES);
        PlayingCard d4 = new PlayingCard(Rank.FOUR, Suit.DIAMONDS);
        PlayingCard s5 = new PlayingCard(Rank.FIVE, Suit.SPADES);
        PlayingCard d5 = new PlayingCard(Rank.FIVE, Suit.DIAMONDS);
        PlayingCard hq = new PlayingCard(Rank.QUEEN, Suit.HEARTS);

        PlayingCard c5 = new PlayingCard(Rank.FIVE, Suit.CLUBS);

        PlayingCard d6 = new PlayingCard(Rank.SIX, Suit.DIAMONDS);
        PlayingCard d7 = new PlayingCard(Rank.SEVEN, Suit.DIAMONDS);
        PlayingCard c7 = new PlayingCard(Rank.SEVEN, Suit.CLUBS);

        PlayingCard hk = new PlayingCard(Rank.KING, Suit.HEARTS);
        PlayingCard da = new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        PlayingCard dk = new PlayingCard(Rank.KING, Suit.DIAMONDS);

        PlayingCard d9 = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
        PlayingCard d0 = new PlayingCard(Rank.TEN, Suit.DIAMONDS);

        PlayingCard s9 = new PlayingCard(Rank.NINE, Suit.SPADES);
        PlayingCard s0 = new PlayingCard(Rank.TEN, Suit.SPADES);

        PlayingCard sa = new PlayingCard(Rank.ACE, Suit.SPADES);
        PlayingCard sk = new PlayingCard(Rank.KING, Suit.SPADES);
        PlayingCard sj = new PlayingCard(Rank.JACK, Suit.SPADES);
        PlayingCard sq = new PlayingCard(Rank.QUEEN, Suit.SPADES);

        ArrayList<PlayingCard> pair3 = new ArrayList();//3pair
        pair3.add(s3);
        pair3.add(d3);
        pair3.add(s4);
        pair3.add(d4);
        pair3.add(s5);
        pair3.add(d5);
        pair3.add(hq);

        ArrayList<PlayingCard> toak = new ArrayList();//2pair 3 of a kind
        toak.add(s3);
        toak.add(d3);
        toak.add(s4);
        toak.add(d4);
        toak.add(s5);
        toak.add(d5);
        toak.add(c5);

        ArrayList<PlayingCard> straight = new ArrayList();//straight
        straight.add(d3);
        straight.add(s4);
        straight.add(d4);
        straight.add(s5);
        straight.add(d6);
        straight.add(c7);
        straight.add(d7);

        ArrayList<PlayingCard> flush = new ArrayList();//flush
        flush.add(da);
        flush.add(s4);
        flush.add(d4);
        flush.add(hk);
        flush.add(d6);
        flush.add(dk);
        flush.add(d7);

        ArrayList<PlayingCard> sf = new ArrayList();//straight flush
        sf.add(d3);
        sf.add(d4);
        sf.add(s5);
        sf.add(d6);
        sf.add(d7);
        sf.add(d9);
        sf.add(d0);

        ArrayList<PlayingCard> rf = new ArrayList();//royalflush
        rf.add(sa);
        rf.add(d4);
        rf.add(sk);
        rf.add(sq);
        rf.add(sj);
        rf.add(s9);
        rf.add(s0);

        ArrayList<PlayingCard> sfl = new ArrayList();//stright flush lwer than striaght
        sfl.add(d3);
        sfl.add(d4);
        sfl.add(s5);
        sfl.add(d6);
        sfl.add(d7);
        sfl.add(s9);
        sfl.add(s0);
    
    ca.sheridancollege.project.HandValueChecker h2 = new ca.sheridancollege.project.HandValueChecker(pair3);
//    ca.sheridancollege.project.HandValueChecker h3 = new ca.sheridancollege.project.HandValueChecker(toak);
//    ca.sheridancollege.project.HandValueChecker h4 = new ca.sheridancollege.project.HandValueChecker(straight);
//    ca.sheridancollege.project.HandValueChecker h5 = new ca.sheridancollege.project.HandValueChecker(flush);
//    ca.sheridancollege.project.HandValueChecker h6 = new ca.sheridancollege.project.HandValueChecker(sf);
//    ca.sheridancollege.project.HandValueChecker h7 = new ca.sheridancollege.project.HandValueChecker(rf);
//    ca.sheridancollege.project.HandValueChecker h8 = new ca.sheridancollege.project.HandValueChecker(sfl);

    //game tester
    TexasHoldem th1 = new TexasHoldem("game1");

    System.out.println (
    "Enter Number of players: ");
        int numOfPlayers = TexasUserInput.getNumPlayers();
    ArrayList<Player> playerArr = new ArrayList<Player>();

    for (int i = 0;
    i< numOfPlayers ;
    i

    
        ++){
            System.out.println("Enter Player name: ");
        String name = UserInput.getString();
        System.out.println("Enter Player ID: ");
        String id = UserInput.getString();
        System.out.println("How much money they got?");
        double wallet = UserInput.getDouble();
        playerArr.add(new TexasPlayer(name, id, wallet));
    }

    th1.setPlayers (playerArr);

    TexasRound round1 = new TexasRound(playerArr, th1.getFirstPlayer());

}

}
