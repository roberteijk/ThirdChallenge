package net.vandeneijk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdChallengeTest {

    @Test
    void calculateRaceResultNotNull() {
        ThirdChallenge challenge = new ThirdChallenge();
        assertNotEquals(null, challenge.calculateRaceResult(10, new Integer[]{10,20,40,30}, new Integer[]{5,20,200,100}));
    }

    @Test
    void calculateRaceResultOrder() {
        ThirdChallenge challenge = new ThirdChallenge();
        assertArrayEquals(new Integer[]{2, 3, 1, 0}, challenge.calculateRaceResult(10, new Integer[]{10, 20, 40, 30}, new Integer[]{5, 20, 200, 100}));
    }

    @Test
    void calculateRaceResultAsByExample1Readme() {
        ThirdChallenge challenge = new ThirdChallenge();
        assertArrayEquals(new Integer[]{1, 0}, challenge.calculateRaceResult(10, new Integer[]{2, 2}, new Integer[]{2, 4}));
    }

    @Test
    void calculateRaceResultAsByExample2Readme() {
        ThirdChallenge challenge = new ThirdChallenge();
        assertArrayEquals(new Integer[]{0, 1}, challenge.calculateRaceResult(10, new Integer[]{2, 2}, new Integer[]{2, 2}));
    }

    @Test
    void calculateRaceResultEbrahimsTestM() {
        ThirdChallenge challenge = new ThirdChallenge();
        assertArrayEquals(new Integer[]{4, 3, 5, 0, 1, 2}, challenge.calculateRaceResult(27, new Integer[]{3, 2, 2, 18, 14, 9}, new Integer[]{151, 236, 152, 15, 163, 275}));
    }
}