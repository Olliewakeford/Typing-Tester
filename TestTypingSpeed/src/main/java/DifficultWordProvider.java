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
            words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/RandomWords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> difficultWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 8) {
                difficultWords.add(word);
            }
        }

        Collections.shuffle(difficultWords);
        return difficultWords.subList(0, Math.min(difficultWords.size(), 200));
    }
}