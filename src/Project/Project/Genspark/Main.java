package Project.Genspark;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! What's your name?");
        String name = in.nextLine();
        boolean anotherRound = false;
        do {
            playGame(in, name);
            System.out.println("Would you like to play again?");
            anotherRound = in.nextLine().toLowerCase(Locale.ROOT).startsWith("y");
        } while (anotherRound);

    }

    public static void playGame(Scanner in, String name) {
        Comparison comparison;
        GuessState guessState = new GuessState();
        String intro = "Well, %s, I am thinking of a number between 1 and %d %n" +
                "Take a guess.";
        System.out.println(String.format(intro, name, guessState.getMaxGuess()));
        do {
            try {
                comparison = guessState.checkGuess(Integer.parseInt(in.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid guess: try again");
                continue;
            }
            if (comparison == Comparison.LOW)
                System.out.println("Your guess is too low");
            if (comparison == Comparison.HIGH)
                System.out.println("Your guess is too high");

        } while (guessState.getState() == State.GUESSING);

        if (guessState.getState() == State.WON) {
            System.out.println(String.format(
                    "Good job, %s! You guessed my number in %s guesses!",
                    name, guessState.getNumberOfGuesses()));
        } else {
            System.out.println(String.format("You couldn't guess my number in %d guesses.%n" +
                    "Better luck next time!%n", guessState.getNumberOfGuesses()));
        }
    }
}
