package Project.Genspark;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class GuessStateTest {

    GuessState guessState;

    @BeforeEach
    void setUp() {
        guessState = new GuessState();
    }

    @Test
    void getState() {
        assertEquals(State.GUESSING, guessState.getState());
    }

    @Test
    void checkGuess() {
        Comparison comparison = guessState.checkGuess(10);
        if (guessState.getActualNumber() != 10) {
            assertEquals(State.GUESSING, guessState.getState());
            assertNotEquals(Comparison.EQUAL, comparison);
        } else {
            assertEquals(State.WON, guessState.getState());
            assertNotEquals(Comparison.EQUAL, comparison);
        }
        if (guessState.getActualNumber() > 10) {
            assertEquals(Comparison.LOW, comparison);
        } else if (guessState.getActualNumber() < 10) {
            assertEquals(Comparison.HIGH, comparison);
        }
        GuessState guessState2 = new GuessState();
        comparison = guessState2.checkGuess(guessState2.getMaxGuess() + 1);
        assertEquals(Comparison.HIGH, comparison);
        assertNotEquals(State.WON, guessState2.getState());

        GuessState guessState3 = new GuessState();
        comparison = guessState3.checkGuess(0);
        assertEquals(Comparison.LOW, comparison);
        assertNotEquals(State.WON, guessState2.getState());
    }
}