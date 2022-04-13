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
        guessState.checkGuess(10);
        if (guessState.getActualNumber() != 10)
            assertEquals(State.GUESSING, guessState.getState());
        else
            assertNotEquals(State.GUESSING, guessState.getState());
    }
}