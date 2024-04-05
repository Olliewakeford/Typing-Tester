package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select an option for the typing test (just enter the number):");
        System.out.println("1. Random sentences with actual english words");
        System.out.println("2. Sentences with nonsense words");
        System.out.println("3. Normal sentences");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt(); //read integer to specify option

        //different kind of words/sentences for user to type
        ParagraphProvider paragraphProvider;

        //switch statement to select the option of words
        switch (option) {
            case 1:
                paragraphProvider = new RandomSentenceProvider();
                break;
            case 2:
                paragraphProvider = new NonsenseSentenceProvider();
                break;
            case 3:
                paragraphProvider = new NormalSentenceProvider();
                break;
            default:
                System.out.println("Invalid option. Exiting...");
                return;
        }
//        System.out.println(paragraphProvider.getSentences());

        //create a new typing test with the selected words
        TypingTest typingTest = new TypingTest(paragraphProvider);
        Result result = typingTest.startTest();

        //print the result of the typing test
        System.out.println("Your typing speed is " + result.getSpeed() + " words per minute with an accuracy of " + result.getAccuracy() + "%.");
    }
}