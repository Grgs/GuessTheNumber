package Project.Genspark;

import java.util.Random;

public class GuessState {

    private int actualNumber;
    private int numberOfGuesses;

    private final int maxNumberOfGuesses = 6;


    private final int maxGuess = 20;
    private Random rnd;
    private State state;

    public GuessState() {
        this.numberOfGuesses = 0;
        rnd = new Random();
        this.actualNumber = rnd.nextInt(maxGuess + 1);
        state = State.GUESSING;
    }

    public Comparison checkGuess(int guess) {
        this.numberOfGuesses++;
        if (guess == this.actualNumber) {
            this.state = State.WON;
            return Comparison.EQUAL;
        }
        if (this.numberOfGuesses >= this.maxNumberOfGuesses &&
                this.state == State.GUESSING) {
            this.state = State.LOST;
        }
        if (guess > this.actualNumber)
            return Comparison.HIGH;
        return Comparison.LOW;
    }

    public int getActualNumber() {
        return actualNumber;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public State getState() {
        return state;
    }

    public int getMaxNumberOfGuesses() {
        return maxNumberOfGuesses;
    }

    public int getMaxGuess() {
        return maxGuess;
    }
}
