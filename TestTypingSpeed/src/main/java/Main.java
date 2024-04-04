package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select an option for the typing test (just enter the number):");
        System.out.println("1. Random words");
        System.out.println("2. Difficult words");
        System.out.println("3. Normal sentences");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt(); //read integer to specify option

        //different kind of words/sentences for user to type
        WordProvider wordProvider;

        //switch statement to select the option of words
        switch (option) {
            case 1:
                wordProvider = new RandomWordProvider();
                break;
            case 2:
                wordProvider = new DifficultWordProvider();
                break;
            case 3:
                wordProvider = new NormalWordProvider();
                break;
            default:
                System.out.println("Invalid option. Exiting...");
                return;
        }
        System.out.println(wordProvider.getWords());

    }
}