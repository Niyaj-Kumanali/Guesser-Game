import java.util.Scanner;

class Guesser{

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey Guesser, guess a number : ");
        return sc.nextInt();
    }
}

class Player{

    public static int guessNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hey Player, guess a number : ");
        return sc.nextInt();
    }
}

class Umpire{
    static int guesserNum;
    static int p1Guess;
    static int p2Guess;
    static int p3Guess;

    public static void getNumFromGuesser() {
        guesserNum = Guesser.getNumber();
    }

    public static void collectNumbersFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1Guess = p1.guessNumbers();
        p2Guess = p2.guessNumbers();
        p3Guess = p3.guessNumbers();
    }

    public static void calcResult() {

        if(guesserNum == p1Guess){
            if(guesserNum == p2Guess && guesserNum == p3Guess){
                System.out.println(" **** All the Player have guessed the correct answer ****");
            }
            else if(guesserNum == p2Guess){
                System.out.println(" **** Player 1 and 2 have guessed the correct answer ****");
            }
            else if(guesserNum == p3Guess){
                System.out.println(" **** Player 1 and 3 have guessed the correct answer ****");
            }
            else{
                System.out.println("**** Player 1 have guessed the correct answer ****");
            }
        }
        else if(guesserNum == p2Guess){
            if(guesserNum == p3Guess){
                System.out.println(" **** Player 2 and 3 have guessed the correct answer ****");
            }
            else{
                System.out.println("**** Player 2 have guessed the correct answer ****");
            }
        }
        else if(guesserNum == p3Guess){
            System.out.println("**** Player 3 have guessed the correct answer ****");
        }
        else{
            System.out.println("**** You have guessed wrong answers ****");
        }
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        Umpire.getNumFromGuesser();
        Umpire.collectNumbersFromPlayers();
        Umpire.calcResult();

    }
}
