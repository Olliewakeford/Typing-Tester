package main.java;

import java.util.List;
import java.util.Arrays;

// Implementation of WordProvider that provides words that when combined
// in order of the list form normal sentences
// Normal sentences are sentences that make sense and are easy to type
public class NormalWordProvider implements WordProvider {
    @Override
    public List<String> getWords() {
        // Implement logic to get normal words
        // This can be from a file or online database

        // For now, returning a list of normal words
        return Arrays.asList("This", "is", "a", "test", "sentence"");
    }
}