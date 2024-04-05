package main.java;

import java.util.List;
import java.util.Scanner;

public class TypingTest {
    private ParagraphProvider paragraphProvider; //Type of paragraph provider

    public TypingTest(ParagraphProvider paragraphProvider) {
        this.paragraphProvider = paragraphProvider;
    }

    // Method to start the typing test,
    // get the user input and calculate the speed and accuracy
    public Result startTest() {
        List<String> sentences = paragraphProvider.getSentences();
        int totalWords = 0;
        int correctWords = 0;

        System.out.println("Type the following sentences, including capitalization and punctuation. Press Enter after each sentence.");
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);

        for (String sentence : sentences) {
            System.out.println(sentence); //print the sentence for the user to type
            String[] wordsOfSentence = sentence.split(" ");
            totalWords += wordsOfSentence.length; //count the total words in the sentence

            String input = scanner.nextLine(); //get the user input of the typed sentence
            String[] inputWords = input.split(" ");

            for (int i = 0; i < wordsOfSentence.length; i++) {
                if (i < inputWords.length && wordsOfSentence[i].equals(inputWords[i])) {
                    correctWords++;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        int speed = (int) ((correctWords / (double) testTime) * 60000);
        int accuracy = (int) ((correctWords / (double) totalWords) * 100);

        return new Result(speed, accuracy);
    }
}