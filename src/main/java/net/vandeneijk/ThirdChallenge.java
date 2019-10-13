package net.vandeneijk;

import java.util.*;

class ThirdChallenge {

    Integer[] calculateRaceResult(int distance, Integer[] acceleration, Integer[] topSpeed) {
        validateParameters(distance, acceleration, topSpeed);
        List<RaceCar> grid = getGrid(distance, acceleration, topSpeed);
        runRace(grid);
        return getRaceResult(grid);
    }

    private void validateParameters(int distance, Integer[] acceleration, Integer[] topSpeed) {
        if (distance <= 0) throw new IllegalArgumentException("Parameter distance must be greater than 0.");
        if (acceleration == null) throw new IllegalArgumentException("Parameter acceleration may not be null.");
        if (topSpeed == null) throw new IllegalArgumentException("Parameter topSpeed may not be null.");
        if (acceleration.length != topSpeed.length) throw new IllegalArgumentException("Parameters acceleration and topSpeed must be the same length.");
        if (Arrays.stream(acceleration).anyMatch(Objects::isNull)) throw new NullPointerException("Null values in the acceleration array are not allowed.");
        if (Arrays.stream(topSpeed).anyMatch(Objects::isNull)) throw new NullPointerException("Null values in the topSpeed array are not allowed.");
    }

    private List<RaceCar> getGrid(int distance, Integer[] acceleration, Integer[] topSpeed) {
        List<RaceCar> grid = new ArrayList<>();
        RaceCar.setDistance(distance);
        for (int i = 0; i < acceleration.length; i++) grid.add(new RaceCar(i, acceleration[i], topSpeed[i]));
        return grid;
    }

    private void runRace(List<RaceCar> grid) {
        for (RaceCar raceCar : grid) raceCar.race();
        grid.sort(Comparator.comparingDouble(RaceCar::getSecondsToFinish));
    }

    private Integer[] getRaceResult(List<RaceCar> grid) {
        Integer[] ranking = new Integer[grid.size()];
        for (int i = 0; i < grid.size(); i++) ranking[i] = grid.get(i).getStartNumber();
        return ranking;
    }
}
