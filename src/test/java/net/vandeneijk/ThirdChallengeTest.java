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
        assertArrayEquals(new Integer[]{2,3,1,0}, challenge.calculateRaceResult(10, new Integer[]{10,20,40,30}, new Integer[]{5,20,200,100}));
    }
}