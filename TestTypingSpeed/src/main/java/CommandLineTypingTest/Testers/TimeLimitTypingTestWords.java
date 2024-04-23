package CommandLineTypingTest.Testers;

import CommandLineTypingTest.Providers.TextToTypeProvider;
import CommandLineTypingTest.Result;

import java.util.List;
import java.util.Scanner;

/**
 * TypingTester implementation that tests the user on typing single words at a time with a time limit.
 */
public class TimeLimitTypingTestWords implements TypingTester {
    private final TextToTypeProvider textToTypeProvider;
    private final long testLength;

    /**
     * Constructs a new TimeLimitTypingTestWords with the specified TextToTypeProvider and test length.
     *
     * @param textToTypeProvider the provider for the text to type
     * @param testLength the length of the test in milliseconds
     */
    public TimeLimitTypingTestWords(TextToTypeProvider textToTypeProvider, long testLength) {
        this.textToTypeProvider = textToTypeProvider;
        this.testLength = testLength;
    }

    /**
     * Starts the test, which prints one word at a time and waits for the user to type it.
     *
     * @return the result of the test
     */
    @Override
    public Result startTest() {
        List<String> words = textToTypeProvider.getTextToType();
        int totalWords = 0;
        int correctWords = 0;

        System.out.println("Type the following words. You have " + (testLength / 1000) + " seconds. Press Enter after each word.");
        System.out.println("\nPress Enter to start the test.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter

        long startTime = System.currentTimeMillis();

        for (String word : words) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            if (elapsedTime >= testLength) { // Break the loop if the test time has been reached
                System.out.println("\nTime's up!");
                break;
            }

            //print word to type
            System.out.println(word);
            String inputWord = scanner.nextLine();
            totalWords++;

            if (word.equals(inputWord)) { // check if the word is typed correctly
                correctWords++;
            }
        }

        long actualTestTime = System.currentTimeMillis() - startTime; // exact length of test

        return new Result(actualTestTime, correctWords, totalWords);
    }
}
