package buildingwithjava;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int secretNum = rand.nextInt(21) + 1;

        System.out.println("I am thinking of a number between 1 and 20.");

        int guess = -1;
        int guesses = 1;
        while (guesses <= 6) {
            System.out.println("Take a guess.");
            guess = scanner.nextInt();

            if (guess < secretNum) {
                System.out.println("Your guess is too low.");
            } else if (guess > secretNum) {
                System.out.println("Your guess is too high.");
            } else {
                break;
            }

            guesses += 1;
        }

        if (guess == secretNum) {
            System.out.println("Good job! You guessed my number in " + guesses + " guesses!");
        } else {
            System.out.println("Nope. The number I was thinking of was " + secretNum);
        }
    }
}