package CommandLineTypingTest.Testers;

// Import the necessary Java classes
import CommandLineTypingTest.Providers.TextToTypeProvider;
import CommandLineTypingTest.Result;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * TypingTester implementation that tests the user on typing sentences at a time with a time limit.
 */
public class TimeLimitTypingTestSentences implements TypingTester {
    // The TextToTypeProvider instance used to fetch sentences for the typing test
    private final TextToTypeProvider textToTypeProvider;
    // The duration of the test in milliseconds
    private final long testLength;

    /**
     * Constructs a new TimeLimitTypingTestSentences with the specified TextToTypeProvider and test length.
     *
     * @param textToTypeProvider the provider for the text to type
     * @param testLength the length of the test in milliseconds
     */
    public TimeLimitTypingTestSentences(TextToTypeProvider textToTypeProvider, long testLength) {
        this.textToTypeProvider = textToTypeProvider;
        this.testLength = testLength;
    }

    /**
     * Starts the test, which prints sentences at a time and ends after the user completes typing it or the time limit is reached.
     *
     * @return the result of the test
     */
    public Result startTest() {
        // Fetch the sentences for the test
        List<String> sentences = textToTypeProvider.getTextToType();
        // Initialize counters for the total words and correct words typed by the user
        int totalWords = 0;
        int correctWords = 0;

        // Print the instructions for the test
        System.out.println("Type the following sentences, including capitalization and punctuation.");
        System.out.println("You have 60 seconds. Press Enter after each sentence.");
        System.out.println("Press Enter to start the test.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter

        // Record the start time of the test
        long startTime = System.currentTimeMillis();

        // To handle the users input in a separate thread to the control of test duration
        // This allows us to end the test as soon as the time is up
        // Create an ExecutorService to run tasks in a separate thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> futureInput;

        // Iterate over each sentence
        for (String sentence : sentences) {
            // Calculate the remaining time for the test
            long currentTime = System.currentTimeMillis();
            long remainingTime = testLength - (currentTime - startTime);

            // Break the loop if the test time has been reached
            if (remainingTime <= 0) {
                break;
            }

            // Print the current sentence for the user to type
            System.out.println(sentence);
            String[] wordsOfSentence = sentence.split(" ");

            // Submit a task to the executor to capture the user's input in a separate thread
            futureInput = executor.submit(scanner::nextLine);

            try {
                // Get the user's input, waiting if necessary for the computation to complete
                String inputSentence = futureInput.get(remainingTime, TimeUnit.MILLISECONDS);
                String[] inputWords = inputSentence.split(" ");
                totalWords += wordsOfSentence.length;

                // Compare the user's input with the original sentence
                for (int i = 0; i < inputWords.length; i++) {
                    if (i < wordsOfSentence.length && wordsOfSentence[i].equals(inputWords[i])) {
                        correctWords++;
                    }
                }

            } catch (TimeoutException e) {
                // handle the case where the time limit is reached
                System.out.println("\nTime's up!");
                break;

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor
        executor.shutdownNow();

        // Calculate the actual test time
        long actualTestTime = System.currentTimeMillis() - startTime;

        // Return a Result object containing the test results
        return new Result(actualTestTime, correctWords, totalWords);
    }
}