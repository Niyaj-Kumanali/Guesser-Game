import java.util.Scanner;

class Guesser {
    public int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey Guesser, guess a number: ");
        return sc.nextInt();
    }
}

class Player {
    public int guessNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey Player, guess a number: ");
        return sc.nextInt();
    }
}

class Umpire {
    private int guesserNum;
    private int[] playerGuesses;

    public void getNumFromGuesser() {
        Guesser guesser = new Guesser();
        guesserNum = guesser.getNumber();
    }

    public void collectNumbersFromPlayers() {
        Player[] players = new Player[3];
        playerGuesses = new int[3];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            playerGuesses[i] = players[i].guessNumber();
        }
    }

    public void calculateResult() {
        boolean guesserCorrect = false;
        boolean playersCorrect = false;

        // Check if any player has guessed the correct number
        for (int guess : playerGuesses) {
            if (guesserNum == guess) {
                playersCorrect = true;
                break;
            }
        }

        // Check if all players and the guesser have guessed the correct number
        if (guesserNum == playerGuesses[0] && guesserNum == playerGuesses[1] && guesserNum == playerGuesses[2]) {
            guesserCorrect = true;
        }

        // Determine the result based on the guesses
        if (guesserCorrect && playersCorrect) {
            System.out.println("**** All the players have guessed the correct answer ****");
        } else if (guesserCorrect) {
            System.out.println("**** Guesser and some players have guessed the correct answer ****");
        } else if (playersCorrect) {
            System.out.println("**** Some players have guessed the correct answer ****");
        } else {
            System.out.println("**** You have guessed wrong answers ****");
        }
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        Umpire umpire = new Umpire();
        umpire.getNumFromGuesser();
        umpire.collectNumbersFromPlayers();
        umpire.calculateResult();
    }
}
