import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ROCK, PAPER, SCISSORS");

        int wins = 0, losses = 0, ties = 0;

        while (true) {
            System.out.printf("%s Wins, %s Losses, %s Ties\n", wins, losses, ties);
            System.out.println("Enter your move: (r)ock, (p)aper, (s)cissors or (q)uit");
            String playerMove = scanner.next();

            if (playerMove.equals("q")) {
                break;
            }

            if (playerMove.equals("r")) {
                System.out.println("ROCK versus...");
            } else if (playerMove.equals("p")) {
                System.out.println("PAPER versus...");
            } else if (playerMove.equals("s")) {
                System.out.println("SCISSORS versus...");
            }

            String computerMove = "";
            int randNum = rand.nextInt(3);
            if (randNum == 0) {
                computerMove = "r";
                System.out.println("ROCK");
            } else if (randNum == 1) {
                computerMove = "p";
                System.out.println("PAPER");
            } else {
                computerMove = "s";
                System.out.println("SCISSORS");
            }

            if (playerMove.equals(computerMove)) {
                ties += 1;
                System.out.println("It is a tie!");
            } else if (playerMove.equals("r") && computerMove.equals("p")) {
                losses += 1;
                System.out.println("You lose!");
            } else if (playerMove.equals("p") && computerMove.equals("s")) {
                losses += 1;
                System.out.println("You lose!");
            } else if (playerMove.equals("s") && computerMove.equals("r")) {
                losses += 1;
                System.out.println("You lose!");
            } else if (playerMove.equals("r") && computerMove.equals("s")) {
                wins += 1;
                System.out.println("You win!");
            } else if (playerMove.equals("p") && computerMove.equals("r")) {
                wins += 1;
                System.out.println("You win!");
            } else if (playerMove.equals("s") && computerMove.equals("p")) {
                wins += 1;
                System.out.println("You win!");
            }
        }
    }
}
