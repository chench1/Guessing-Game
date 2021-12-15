/*
Author - Charles Chen
Date - 12/14/2021
Purpose - Program gets a random number and has the user try and guess the number. THe program will tell the user if the guess
is too low or too high.
*/

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess an integer from 1 to 500. If your guess is too low they program will tell you and vice versa. \nTo exit the game type N anytime.");
        int num = (int)((Math.random()*499) + 1);
        boolean exit = false;
        int numGuesses = 1;
        int max = 500, min = 1;
        boolean increase = true;
        // game loop
        while (true) {
            String input = scan.nextLine();
            int guess = 0;
            // checks if user wants to exit
            if (input.equals("N")) {
                break;
            }
            try {
                guess = Integer.parseInt(input);

                if (guess > max || guess < min) {
                    System.out.println("Outside of range you dumbo. Increasing number of guesses anyways.");
                    numGuesses++;
                    continue;
                }

                if (guess > num) {
                    max = guess;
                    System.out.println("This guess was guess number " + numGuesses + ". Your guess is too large. Enter a number between " + min + " and " + max);
                } else if (guess < num) {
                    min = guess;
                    System.out.println("This guess was guess number " + numGuesses + ". Your guess is too small. Enter a number between " + min + " and " + max);
                } else {
                    System.out.println("You chose the correct number. It took you " + numGuesses+ " guesses. Type Y if you would like to start a new game and anything else to exit");
                    String continuing = scan.nextLine();
                    if (continuing.equals("Y")) {
                        num = (int)(Math.random()*500 + 1);
                        numGuesses = 1;
                        max = 500;
                        min = 1;
                        System.out.println("Enter a number between 1 and 500");
                        continue;
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                increase = false;
            }
            if (increase) {
                numGuesses++;
            }
            increase = true;
        }
        System.out.println("The program is terminating.");
    }
}