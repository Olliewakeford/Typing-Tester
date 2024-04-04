package main.java;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of WordProvider to provide difficult words for user to type
// Difficult words are words that are hard to spell and contain more letters
// This makes them more challenging to type
public class DifficultWordProvider implements WordProvider {
    @Override
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        try {
            //get a list of all words from the RandomWords.txt file
            words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/RandomWords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create a list of difficult words from the list of all words
        List<String> difficultWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 8) {
                difficultWords.add(word);
            }
        }

        Collections.shuffle(difficultWords); //shuffle the list of difficult words
        //return the first 200 difficult words
        return difficultWords.subList(0, Math.min(difficultWords.size(), 200));
    }
}