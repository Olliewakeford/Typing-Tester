package CommandLineTypingTest.Providers;

import CommandLineTypingTest.RandomSentence;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of WordProvider to provide random words for user to type
// Random words do not form sentences which make sense
// This makes them more difficult to type
public class RandomSentenceProvider implements TextToTypeProvider {
    List<String> words;

    public RandomSentenceProvider() {
        words = new ArrayList<>();
        try {
            //get a list of all words from the RandomWords.txt file
            words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/RandomWords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTextToType() {
        List<String> paragraph = new ArrayList<>(); //List of sentences to be returned

        for (int i = 0; i < 40; i++) {
            String sentence = RandomSentence.createRandomSentence(words); //create a sentence of random words
            paragraph.add(sentence);
        }

        return paragraph;
    }
}