package CommandLineTypingTest;


public record Result(long testTime, int correctWords, int totalWords) {

    // Method to calculate the speed of the user as words per minute
    public int calculateSpeed() {
        int seconds = (int) Math.floor((double) testTime / 1000);
        return (int) ((double) correctWords / seconds * 60);
    }

    // return the percentage of words spelt perfectly
    public int calculateAccuracy() {
        return (int) ((double) correctWords / totalWords * 100);
    }

    // Method to display the result of the test
    @Override
    public String toString() {
        double testTimeInMinutes = testTime / 60000.0;
        int speed = calculateSpeed();
        int accuracy = calculateAccuracy();

        return "Test Duration: " + testTimeInMinutes + " minutes\n" +
                "Total Words: " + totalWords + "\n" +
                "Correct Words: " + correctWords + "\n" +
                "Speed: " + speed + " words per minute\n" +
                "Accuracy: " + accuracy + "%\n";
    }
}

