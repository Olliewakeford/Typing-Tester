package CommandLineTypingTest;

import java.util.List;
import java.util.Scanner;

public class TypingTest {
    private final ParagraphProvider paragraphProvider; //Type of paragraph provider

    public TypingTest(ParagraphProvider paragraphProvider) {
        this.paragraphProvider = paragraphProvider;
    }

    // Method to start the typing test,
    // get the user input and calculate the speed and accuracy
    public Result startTest() {
        List<String> sentences = paragraphProvider.getSentences();
        int totalWords = 0;
        int correctWords = 0;

        // Display the instructions to the user
        System.out.println("Type the following sentences, including capitalization and punctuation.");
        System.out.println("You have 60 seconds. Press Enter after each sentence.");
        System.out.println("Finish the sentence you are on when time expires, then press Enter to see your results.");
        System.out.println("Press Enter to start the test.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        long startTime = System.currentTimeMillis();

        for (String sentence : sentences) {
            System.out.println(sentence); //print the sentence for the user to type
            String[] wordsOfSentence = sentence.split(" "); //split the sentence into words

            for (String s : wordsOfSentence) {

                if (scanner.hasNext()) {
                    String inputWord = scanner.next();
                    totalWords++; //count the total words in the sentence

                    if (s.equals(inputWord)) {
                        correctWords++;
                    }
                }
            }

            long currentTime = System.currentTimeMillis();
            // one minute has passed
            if (currentTime - startTime >= 60000) {
                break;
            }
        }


        long testTime = System.currentTimeMillis() - startTime;

        return new Result(testTime, correctWords, totalWords);
    }
}