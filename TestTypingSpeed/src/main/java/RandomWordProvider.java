package main.java;

import java.util.List;
import java.util.Arrays;

// Implementation of WordProvider to provide random words for user to type
// Random words do not form sentences which make sense
// This makes them more difficult to type
public class RandomWordProvider implements WordProvider {
    @Override
    public List<String> getWords() {
        // Implement logic to get random words
        //This can be from a file or online database

        // For now, returning a list of random words
        return Arrays.asList("word1", "word2", "word3");
    }
}