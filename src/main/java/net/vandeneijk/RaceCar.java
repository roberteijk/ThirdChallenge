package net.vandeneijk;

import java.text.DecimalFormat;

class RaceCar {
    private static final DecimalFormat STANDARDIZED_NOTATION = new DecimalFormat("#.###");
    private static double distance;
    private int startNumber;
    private double acceleration;
    private double topSpeed;
    private Double secondsToFinish;


    RaceCar(int startNumber, double acceleration, double topSpeed) {
        this.startNumber = startNumber;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
    }

    static void setDistance(int distance) {
        if (distance <= 0) throw new IllegalArgumentException("Parameter distance must be greater than 0.");
        RaceCar.distance = distance;
    }

    RaceCar race() {
        double distanceDuringAcceleration = getDistanceDuringAcceleration();
        if (distanceDuringAcceleration > distance) secondsToFinish = getTimeSpendAccelerating(distance);
        else secondsToFinish = getTimeSpendAccelerating() + getTimeSpendTopSpeed(distanceDuringAcceleration);
        return this;
    }

    int getStartNumber() {
        return startNumber;
    }

    Double getSecondsToFinish() {
        return secondsToFinish;
    }

    private double getTimeSpendAccelerating() {
        return topSpeed / acceleration;
    }

    private double getTimeSpendAccelerating(double distance) {
        return Math.sqrt(distance / acceleration / 0.5);
    }

    private double getTimeSpendTopSpeed(double distanceDuringAcceleration) {
        return  (distance - distanceDuringAcceleration) / topSpeed;
    }

    private double getDistanceDuringAcceleration() {
        return 0.5 * acceleration * Math.pow(topSpeed / acceleration, 2);
    }
}
