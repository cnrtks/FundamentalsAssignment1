
package ca.sheridancollege.project;

public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Deck d1 = new Deck(52);
        System.out.println(d1.toString());
        d1.shuffle();
        System.out.println(d1.toString());
    }
    
}
