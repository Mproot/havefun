import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bagels {

    private static final int NUM_DIGITS = 3;
    private static final int MAX_GUESSES = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "n";

        do {
            String secretNum = getSecretNum();
            //System.out.println(secretNum);
            intro();
            int numGuesses = 1;
            while (numGuesses <= MAX_GUESSES) {

                String guess = "";
                while (true) {
                    System.out.printf("Guess #%s:", numGuesses);
                    System.out.print("> ");
                    guess = scanner.nextLine();

                    if (!guess.isEmpty() && guess.matches("\\d+") && guess.length() == 3) {
                        break;
                    }
                }

                String clues = getClues(secretNum, guess);
                System.out.println(clues);
                numGuesses += 1;

                if (guess.equals(secretNum)) {
                    break;
                }
                if (numGuesses > MAX_GUESSES) {
                    System.out.println("You ran out of guesses.");
                    System.out.printf("The answer was %s.\n", secretNum);
                }

            }

            System.out.println("Do you want to play again? (y/n)");
            playAgain = scanner.nextLine();
        } while (playAgain.toLowerCase().startsWith("y"));
    }

    private static String getClues(String secretNum, String guess) {
        if (secretNum.equals(guess)) {
            return "You got it!";
        }

        List<String> clue = new ArrayList<String>();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secretNum.charAt(i)) {
                clue.add("Fermi");
            } else if (secretNum.contains(guess.subSequence(i, i + 1))) {
                clue.add("Pico");
            }
        }

        if (clue.size() == 0) {
            return "Bagels";
        } else {
            clue.sort(null);
            return clue.toString();
        }

    }
    private static String getSecretNum() {
        String[] s = "0123456789".split("");
        Random rand = new Random();

        for (int i = 0; i < s.length; i++) {
            int randomIndexToSwap = rand.nextInt(s.length);
            String temp = s[randomIndexToSwap];
            s[randomIndexToSwap] = s[i];
            s[i] = temp;
        }

        String result = "";

        for (int i = 0; i < NUM_DIGITS; i++) {
            result += s[i];
        }
        return result;
    }

    // another way to check for numeric
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static void intro() {
        System.out.println("Bagels, a deductive logic game.");
        System.out.println();
        System.out.printf("I am thinking of a %s-digit number. Try to guess what it is.\n", NUM_DIGITS);
        System.out.println("Here are some clues:");
        System.out.println("When I say:     That means:");
        System.out.println("  Pico          One digit is correct but in the wrong position.");
        System.out.println("  Fermi         One digit is correct and in the right position.");
        System.out.println("  Bagels        No digit is correct.");
        System.out.println("I have thought up a number.");
        System.out.printf(" You have %s guesses to get it.\n", MAX_GUESSES);
    }
}
