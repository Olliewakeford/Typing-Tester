package main.java;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of WordProvider to provide random words for user to type
// Random words do not form sentences which make sense
// This makes them more difficult to type
public class RandomSentenceProvider implements ParagraphProvider {
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
    public List<String> getSentences() {
        List<String> paragraph = new ArrayList<>(); //List of sentences to be returned

        for (int i = 0; i < 40; i++) {
            String sentence = createRandomSentence(); //create a sentence of random words
            paragraph.add(sentence);
        }

        return paragraph;
    }

    //create a random sentence of random words
    public String createRandomSentence(){
        String sentence = "";
        Random rand = new Random();
        int numWordsInSentence = rand.nextInt(10) + 5; //to vary sentence length
        for (int i = 0; i < numWordsInSentence; i++) {
            int index = rand.nextInt(words.size()); //choose a random word from the list of all words
            sentence += (words.get(index) + " "); //add the word to the sentence
        }
        sentence += ".";
        return sentence;
    }
}

