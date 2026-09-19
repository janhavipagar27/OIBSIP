
	import java.util.Random;
	import java.util.Scanner;

	public class NumberGuessingGame {

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int round = 1;
	        int totalScore = 0;
	        String playAgain = "yes";

	        System.out.println("=================================");
	        System.out.println("     NUMBER GUESSING GAME");
	        System.out.println("=================================");

	        while (playAgain.equalsIgnoreCase("yes")
	                || playAgain.equalsIgnoreCase("y")) {

	            int secretNumber = random.nextInt(100) + 1;
	            int maxAttempts = 7;
	            int attempts = 0;
	            boolean guessedCorrectly = false;

	            System.out.println("\n---------- ROUND " + round + " ----------");
	            System.out.println("I have selected a number between 1 and 100.");
	            System.out.println("You have " + maxAttempts + " attempts.");

	            while (attempts < maxAttempts) {

	                System.out.print("\nEnter your guess: ");

	                if (!scanner.hasNextInt()) {
	                    System.out.println("Invalid input! Please enter a number.");
	                    scanner.next();
	                    continue;
	                }

	                int guess = scanner.nextInt();
	                attempts++;

	                if (guess < 1 || guess > 100) {
	                    System.out.println("Please enter a number between 1 and 100.");
	                    continue;
	                }

	                if (guess > secretNumber) {
	                    System.out.println("Too High!");
	                } 
	                else if (guess < secretNumber) {
	                    System.out.println("Too Low!");
	                } 
	                else {
	                    guessedCorrectly = true;

	                    int roundScore = maxAttempts - attempts + 1;
	                    totalScore += roundScore;

	                    System.out.println("Correct!");
	                    System.out.println("You guessed the number in "
	                            + attempts + " attempts.");
	                    System.out.println("Round Score: " + roundScore);

	                    break;
	                }

	                System.out.println("Attempts remaining: "
	                        + (maxAttempts - attempts));
	            }

	            if (!guessedCorrectly) {
	                System.out.println("\nYou Lost!");
	                System.out.println("The correct number was: " + secretNumber);
	            }

	            System.out.println("\n---------- SCORE ----------");
	            System.out.println("Round: " + round);
	            System.out.println("Attempts used: " + attempts);
	            System.out.println("Total Score: " + totalScore);

	            System.out.print("\nDo you want to play again? (yes/no): ");
	            playAgain = scanner.next();
	            
	            round++;
	        }

	        System.out.println("\n=================================");
	        System.out.println("       GAME OVER");
	        System.out.println("=================================");
	        System.out.println("Total Rounds Played: " + (round - 1));
	        System.out.println("Final Score: " + totalScore);
	        System.out.println("Thank you for playing!");

	        scanner.close();
	    }
	}

	