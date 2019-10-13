package net.vandeneijk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarTest {

    @Test
    void getSecondsToFinishBeforeTopSpeed() {
        RaceCar raceCar = new RaceCar(0, 25, 1000);
        RaceCar.setDistance(200);
        assertEquals(4, raceCar.race().getSecondsToFinish());
    }

    @Test
    void getSecondsToFinishLongRace() {
        RaceCar raceCar = new RaceCar(0, 5, 100);
        RaceCar.setDistance(300000);
        assertEquals(3010, raceCar.race().getSecondsToFinish());
    }
}