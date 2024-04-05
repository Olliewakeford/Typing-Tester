package main.java;

import java.util.List;
import java.util.Random;

public class RandomSentence {
    //Method to create a random sentence from a list of words
    public static String createRandomSentence(List<String> words) {
        String sentence = "";

        Random rand = new Random();
        int numWordsInSentence = rand.nextInt(10) + 5; //to vary sentence length

        for (int i = 0; i < numWordsInSentence; i++) {
            int index = rand.nextInt(words.size()); //choose a random word from the list of all words

            if (i == 0) {
                sentence += words.get(index).substring(0, 1).toUpperCase() + words.get(index).substring(1) + " "; //capitalize the first word
            } else if (i < numWordsInSentence - 1) {
                sentence += words.get(index) + " "; //add the word to the sentence
            } else {
                sentence += (words.get(index)); //add the word to the sentence without a space at the end
            }
        }

        sentence += ".";
        return sentence;
    }
}