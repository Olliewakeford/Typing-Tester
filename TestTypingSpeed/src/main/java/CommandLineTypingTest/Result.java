package CommandLineTypingTest;


public record Result(long testTime, int totalWords, int correctWords) {

    // Method to calculate the speed of the user as words per minute
    public int calculateSpeed() {
        int seconds = (int) Math.floor((double) testTime / 1000);
        return (int) ((double) correctWords / seconds * 60);
    }

    // return the percentage of words spelt perfectly
    public int calculateAccuracy() {
        return (int) ((double) correctWords / totalWords * 100);
    }



}
