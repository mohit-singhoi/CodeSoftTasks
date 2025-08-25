/* Task1 : Number Guessing Game
Create a simple number guessing game in Java. The game should:

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won. */


package GuessingNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    // Method to play one round
    public static int playRound(Scanner sc, Random random) {
        int number = random.nextInt(100) + 1;  // 1 to 100
        int attempts = 7;
        boolean win = false;
        int points = 0;

        System.out.println("\nI have chosen a number between 1 to 100.");
        System.out.println("You have " + attempts + " attempts to guess it.");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts--;

            if (guess == number) {
                win = true;
                points = attempts + 1; // more attempts left = more points
                System.out.println("Correct! You guessed it.");
                System.out.println("Points earned: " + points);
                break;
            } else if (guess > number) {
                System.out.println("\nToo high! Attempts left: " + attempts);
            } else {
                System.out.println("\nToo low! Attempts left: " + attempts);
            }
        }

        if (!win) {
            System.out.println("\nYou lost! The number was " + number);
        }

        return points;  // return points to add in score
    }
}

    // // Main function
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     Random random = new Random();

    //     int totalScore = 0;
    //     boolean again = true;

    //     System.out.println("Welcome to Number Guessing Game!");

    //     while (again) {
    //         // Call playRound method
    //         int roundScore = playRound(sc, random);
    //         totalScore += roundScore;

    //         System.out.println("Your total score = " + totalScore);

    //         System.out.print("Do you want to play again? (yes/no): ");
    //         String ans = sc.next();
    //         if (!ans.equalsIgnoreCase("y")) {
    //             again = false;
    //         }
    //     }

    //     System.out.println("Game Over! Final Score: " + totalScore);
    //     sc.close();
    // }
//}

