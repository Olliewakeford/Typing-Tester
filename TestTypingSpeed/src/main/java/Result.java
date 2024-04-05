package main.java;

public class Result {
    private final int speed;
    private final int accuracy;

    public Result(int speed, int accuracy) {
        this.speed = speed;
        this.accuracy = accuracy;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAccuracy() {
        return accuracy;
    }
}
