package CommandLineTypingTest.Testers;

import CommandLineTypingTest.Providers.TextToTypeProvider;
import CommandLineTypingTest.Result;

import java.util.List;
import java.util.Scanner;

public class ParagraphTester implements TypingTester {
    TextToTypeProvider textToTypeProvider;

    public ParagraphTester(TextToTypeProvider textToTypeProvider) {
        this.textToTypeProvider = textToTypeProvider;
    }


    // Test which prints one paragraph and ends after the user completes typing it
    @Override
    public Result startTest() {
        // Get the paragraph to type
        List<String> paragraphs = textToTypeProvider.getTextToType();
        String paragraph = String.join(" ", paragraphs);

        // Print the paragraph
        System.out.println(paragraph);
        System.out.println("Press Enter to start the test.");
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
        int totalWords = originalWords.length;
        int correctWords = 0;
        for (int i = 0; i < totalWords; i++) {
            if (originalWords[i].equals(typedWords[i])) {
                correctWords++;
            }
        }

        // Return the result
        return new Result(elapsedTime, correctWords, totalWords);
    }
}
