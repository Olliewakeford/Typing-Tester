package CommandLineTypingTest;

import CommandLineTypingTest.Providers.*;
import CommandLineTypingTest.Testers.ParagraphTester;
import CommandLineTypingTest.Testers.TimeLimitTypingTestSentences;
import CommandLineTypingTest.Testers.TimeLimitTypingTestWords;
import CommandLineTypingTest.Testers.TypingTester;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get the user's choice for the typing test of timed test vs a test which ends after completing a paragraph
        System.out.println("Select your options for the typing test (just enter the number):");
        System.out.println("1. Timed Test - Type until time runs out");
        System.out.println("2. Paragraph Test - Type a paragraph about a java topic");

        int testType = scanner.nextInt();

        TypingTester typingTest;
        TextToTypeProvider textToTypeProvider;

        // switch case to select the type of test
        switch (testType) {
            // Timed test
            case 1:
                //Get the desired length of the typing test
                System.out.println("Select length of timed typing test:");
                System.out.println("1. 30 seconds");
                System.out.println("2. 1 minute");
                System.out.println("3. 3 minutes");
//                System.out.println("4. Custom time (in minutes)");

                int testLengthKey = scanner.nextInt();
                long textLengthMS = convertToMillis(testLengthKey); // Convert the selected test length to milliseconds

                // Get the type of sentences/words to type
                System.out.println("Select what to type:");
                System.out.println("1. Normal Sentences - The entire sentence is printed at a time");
                System.out.println("2. Random Sentences/Words");
                System.out.println("3. Nonsense Sentences/Words");

                int sentenceType = scanner.nextInt();

                switch (sentenceType) {
                    // Normal sentences
                    case 1:
                        //Create the textToTypeProvider which provides normal sentences
                        textToTypeProvider = new NormalSentenceProvider();
                        //Create the typing test which prints sentences at a time
                        typingTest = new TimeLimitTypingTestSentences(textToTypeProvider, textLengthMS);
                        break;

                    // Random words or Random sentences
                    case 2:
                        // Get the format of the typing test of Random words or Random sentences
                        System.out.println("Select typing test form:");
                        System.out.println("1. Print 1 word at a time");
                        System.out.println("2. Print 1 sentence at a time");

                        int format1 = scanner.nextInt();

                        switch (format1) {
                            //one word at a time
                            case 1:
                                textToTypeProvider = new SingleWordsProvider(0);
                                // Create the typing test which prints one random word at a time
                                typingTest = new TimeLimitTypingTestWords(textToTypeProvider, textLengthMS);
                                break;

                            //one sentence at a time
                            case 2:
                                textToTypeProvider = new RandomSentenceProvider();
                                // Create the typing test which prints sentences at a time
                                typingTest = new TimeLimitTypingTestSentences(textToTypeProvider, textLengthMS);
                                break;

                            default:
                                System.out.println("Invalid option. Exiting...");
                                return;
                        }
                        break;

                    // Nonsense words or Nonsense sentences
                    case 3:
                        // Get the format of the typing test of Nonsense words or Nonsense sentences
                        System.out.println("Select typing test form:");
                        System.out.println("1. Print 1 word at a time");
                        System.out.println("2. Print 1 sentence at a time");

                        int format2 = scanner.nextInt();

                        switch (format2) {
                            case 1:
                                textToTypeProvider = new SingleWordsProvider(1);
                                // Create the typing test which prints one random word at a time
                                typingTest = new TimeLimitTypingTestWords(textToTypeProvider, textLengthMS);
                                break;

                            case 2:
                                textToTypeProvider = new NonsenseSentenceProvider();
                                // Create the typing test which prints sentences at a time
                                typingTest = new TimeLimitTypingTestSentences(textToTypeProvider, textLengthMS);
                                break;

                            default:
                                System.out.println("Invalid option. Exiting...");
                                return;
                        }

                        break;

                    default:
                        System.out.println("Invalid option. Exiting...");
                        return;
                }

                break;

            case 2:
                System.out.println("Select the topic of the paragraph:");
                System.out.println("1. Java Overview");
                System.out.println("2. Reflection API");
                System.out.println("3. The Java Platform");
                System.out.println("4. Generics in Java");
                System.out.println("5. Annotations in Java");
                System.out.println("6. Classes and Class Loaders");
                System.out.println("7. Service Loaders and Providers");
                System.out.println("8. Java Bytecode");
                System.out.println("9. Java Native Interface (JNI)");
                System.out.println("10 Java Native Access (JNA)");
                System.out.println("11. Foreign Functions and Memory");

                int topic = scanner.nextInt();

                // Create the ParagraphTester with the selected topic
                textToTypeProvider = new GivenTopicTextToTypeProvider(topic);
                typingTest = new ParagraphTester(textToTypeProvider);
                break;

            default:
                System.out.println("Invalid option. Exiting...");
                return;
        }

        Result result = typingTest.startTest();
        System.out.println(result.toString());
    }

    public static long convertToMillis(int textLengthKey) {
        // Convert the selected test length to milliseconds
        long testLength = 0;
        // 1 represents 30 seconds, 2 represents 1 minute, 3 represents 3 minutes
        if (textLengthKey == 1) {
            testLength = 30 * 1000;
        } else if (textLengthKey == 2) {
            testLength = 60 * 1000;
        } else if (textLengthKey == 3) {
            testLength = 3 * 60 * 1000;
        }
        return testLength;
    }
}