package CommandLineTypingTest;

public class Result {
    private final int speed;
    private final int accuracy;
    private final int totalWords;
    private final int correctWords;

    public Result(int speed, int accuracy, int totalWords, int correctWords) {
        this.speed = speed;
        this.accuracy = accuracy;
        this.totalWords = totalWords;
        this.correctWords = correctWords;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getCorrectWords() {
        return correctWords;
    }
}
