import java.util.Random;
import java.util.Scanner;

class Game1 {
    private int noOfGuesses = 0;
    public int inputNo;
    private int randomNo;

    public Game1() {
        Random rand = new Random();
        int upperBound = 100;
        randomNo = rand.nextInt(upperBound) + 1; // +1 to include 100
    }

    public void takeUserInput(Scanner sc) {
        System.out.print("Guess a number: ");
        inputNo = sc.nextInt();
    }

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    boolean checkGuess() {
        noOfGuesses++;
        if (inputNo == randomNo) {
            System.out.println("🎉 You guessed the number right: " + randomNo);
            System.out.println("✅ You guessed it in " + noOfGuesses + " attempts.");
            return true;
        } else if (inputNo > randomNo) {
            System.out.println("📉 Your number is too high.");
        } else {
            System.out.println("📈 Your number is too low.");
        }
        return false;
    }
}

// Starting main function
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game1 game = new Game1();
        boolean isCorrect = false;

        while (!isCorrect) {
            game.takeUserInput(sc);
            isCorrect = game.checkGuess();
        }

        sc.close(); // close scanner at the end
    }
}
