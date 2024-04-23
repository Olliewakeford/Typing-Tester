package CommandLineTypingTest.Testers;

import CommandLineTypingTest.Providers.TextToTypeProvider;
import CommandLineTypingTest.Result;

import java.util.List;
import java.util.Scanner;

/**
 * TypingTester implementation that tests the user on typing an entire paragraph. No time limit.
 */
public class ParagraphTester implements TypingTester {
    TextToTypeProvider textToTypeProvider;

    /**
     * Constructs a new ParagraphTester with the specified TextToTypeProvider.
     *
     * @param textToTypeProvider the provider for the text to type
     */
    public ParagraphTester(TextToTypeProvider textToTypeProvider) {
        this.textToTypeProvider = textToTypeProvider;
    }

    /**
     * Starts the test, which prints one paragraph and ends after the user completes typing it.
     *
     * @return the result of the test
     */
    @Override
    public Result startTest() {
        // Get the paragraph to type
        List<String> paragraphs = textToTypeProvider.getTextToType();
        String paragraph = String.join(" ", paragraphs);

        // Print the paragraph
        System.out.println(paragraph);
        System.out.println("\nPress Enter to start the test.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter

        // Start the test
        long startTime = System.currentTimeMillis();
        System.out.println("Start typing now.");
        String userInput = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        // Calculate the elapsed time in milliseconds
        long elapsedTime = endTime - startTime;

        // Calculate the total number of words and the number of correct words
        String[] originalWords = paragraph.split("\\s+"); // Match any whitespace
        String[] typedWords = userInput.split("\\s+");
        int totalWords = originalWords.length; // total number of words attempted to type
        int correctWords = 0; // number of words typed perfectly
        for (int i = 0; i < typedWords.length; i++) {
            if (originalWords[i].equals(typedWords[i])) {
                correctWords++;
            }
        }

        // Return the result
        return new Result(elapsedTime, correctWords, totalWords);
    }
}
