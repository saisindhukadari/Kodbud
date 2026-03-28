import java.util.Random;
import java.util.Scanner;
public class Numberguessinggame {
    public static void playGame(int maxAttempts, int range) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int targetNumber = rand.nextInt(range) + 1;
        int guess;
        int attempts = 0;
        System.out.println("\nGuess the number between 1 and " + range);
        System.out.println("You have " + maxAttempts + " attempts.\n");
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess < targetNumber) {
                System.out.println(" Too low!");
            } else if (guess > targetNumber) {
                System.out.println(" Too high!");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                return;
            }
            System.out.println("Remaining attempts: " + (maxAttempts - attempts));
        }
        System.out.println("\nYou lost! The correct number was: " + targetNumber);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            char playAgain = 0;       
            System.out.println("Welcome to Advanced Number Guessing Game!");
            do {
                System.out.println("\nSelect Difficulty Level:");
                System.out.println("1. Easy (1-50, 10 attempts)");
                System.out.println("2. Medium (1-100, 7 attempts)");
                System.out.println("3. Hard (1-200, 5 attempts)");                
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> playGame(10, 50);
                    case 2 -> playGame(7, 100);
                    case 3 -> playGame(5, 200);
                    default -> {
                        System.out.println("Invalid choice. Try again.");
                        continue;
                    }
                }                
                System.out.print("\nDo you want to play again? (y/n): ");
                playAgain = sc.next().charAt(0);
                
            } while (playAgain == 'y' || playAgain == 'Y');            
            System.out.println("Thanks for playing!");
        }
    }
}