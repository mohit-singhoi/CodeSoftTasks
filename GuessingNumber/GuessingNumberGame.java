package GuessingNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame{
      // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean again = true;

        System.out.println("Welcome to Number Guessing Game!");
        while (again) {
            // Call playRound method
            int roundScore = GuessingGame.playRound(sc, random);
            totalScore += roundScore;

            System.out.println("Your total score = " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String ans = sc.next();
            if (!ans.equalsIgnoreCase("y")) {
                again = false;
            }
        }

        System.out.println("\nGame Over!  Your Final Score: " + totalScore);
        sc.close();
    }

}