package CommandLineTypingTest.Testers;

import CommandLineTypingTest.Providers.TextToTypeProvider;
import CommandLineTypingTest.Result;

import java.util.List;
import java.util.Scanner;

public class TimeLimitTypingTestWords implements TypingTester {
    private final TextToTypeProvider textToTypeProvider;
    private final long testLength;

    public TimeLimitTypingTestWords(TextToTypeProvider textToTypeProvider, long testLength) {
        this.textToTypeProvider = textToTypeProvider;
        this.testLength = testLength;
    }

    // Test which prints one word at a time and waits for the user to type it
    @Override
    public Result startTest() {
        List<String> words = textToTypeProvider.getTextToType();
        int totalWords = 0;
        int correctWords = 0;

        System.out.println("Type the following words. You have " + (testLength / 1000) + " seconds. Press Enter after each word.");
        System.out.println("Press Enter to start the test.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter

        long startTime = System.currentTimeMillis();

        for (String word : words) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            if (elapsedTime >= testLength) {
                System.out.println("\nTime's up!");
                break;
            }

            System.out.println(word);
            String inputWord = scanner.nextLine();
            totalWords++;

            if (word.equals(inputWord)) {
                correctWords++;
            }
        }

        long actualTestTime = System.currentTimeMillis() - startTime;

        return new Result(actualTestTime, correctWords, totalWords);
    }
}
