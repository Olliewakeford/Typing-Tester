package main.java;

import java.util.List;
import java.util.Arrays;

// Implementation of WordProvider to provide difficult words for user to type
// Difficult words are words that are hard to spell and contain more letters
// This makes them more challenging to type
public class DifficultWordProvider implements WordProvider {
    @Override
    public List<String> getWords() {
        // Implement logic to get difficult words
        //This can be from a file or online database

        // For now, returning a list of difficult words
        return Arrays.asList("difficult1", "difficult2", "difficult3");
    }
}