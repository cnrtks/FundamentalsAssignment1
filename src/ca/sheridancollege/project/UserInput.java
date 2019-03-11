package ca.sheridancollege.project;

import java.util.Scanner;

public class UserInput {

    public static double getDouble() {
        Scanner kb = new Scanner(System.in);
        double ret;
        try {
            ret = kb.nextDouble();
        } catch (Exception e) {
            System.out.println("\nEnter a number");
            ret = getDouble();
        }
        return ret;
    }

    public static int getInt() {
        Scanner kb = new Scanner(System.in);
        int ret;
        try {
            ret = kb.nextInt();
        } catch (Exception e) {
            System.out.println("\nEnter an integer");
            ret = getInt();
        }
        return ret;
    }

    public static String getString() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }
}
