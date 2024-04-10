package CommandLineTypingTest;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of WordProvider to provide difficult words for user to type
// Difficult words are words that are hard to spell and contain more letters
// This makes them more challenging to type
public class NonsenseSentenceProvider implements ParagraphProvider {
    List<String> words;

    public NonsenseSentenceProvider() {
        words = new ArrayList<>();
        try {
            //get a list of all words from the Nonsense.txt file
            words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/NonsenseWords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getSentences() {
        List<String> paragraph = new ArrayList<>(); //List of sentences to be returned

        //Create 40 random sentences
        for (int i = 0; i < 40; i++) {
            String sentence = RandomSentence.createRandomSentence(words); //create a sentence of random words
            paragraph.add(sentence);
        }

        return paragraph;
    }

}