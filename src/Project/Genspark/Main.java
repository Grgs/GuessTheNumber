package Project.Genspark;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! What's your name?");
        String name = in.nextLine();
        boolean anotherRound = false;
        do{
            playGame(in, name);
            System.out.println("Would you like to play again?");
            anotherRound = in.nextLine().toLowerCase(Locale.ROOT).startsWith("y");
        } while(anotherRound);

    }

    private static void playGame(Scanner in, String name) {
        String intro = "Well, %s, I am thinking of a number between 1 and 20 %n" +
                "Take a guess.";
        System.out.println(String.format(intro, name));
        Random rnd = new Random();
        int number = rnd.nextInt(21);
        int guess;
        int nGuesses = 0;
        do {
            try {
                guess = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e){
                guess = 99;
            }
            nGuesses += 1;
            if (guess < number)
                System.out.println("Your guess is too low");
            if (guess > number)
                System.out.println("Your guess is too high");

        }while (guess != number);
        System.out.println(String.format("Good job, %s! You guessed my number in %s guesses!",
                name, nGuesses));
    }
}
