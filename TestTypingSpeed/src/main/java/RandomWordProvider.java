package main.java;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of WordProvider to provide random words for user to type
// Random words do not form sentences which make sense
// This makes them more difficult to type
public class RandomWordProvider implements WordProvider {
    @Override
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        try {
            //get a list of all words from the RandomWords.txt file
            words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/RandomWords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(words); //shuffle the list of all words
        //return the first 200 random words
        return words.subList(0, Math.min(words.size(), 200));
    }
}