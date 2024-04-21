package CommandLineTypingTest.Providers;


import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of SentenceProvider
// Normal sentences are sentences that make sense and are easy to type
public class NormalSentenceProvider implements TextToTypeProvider {
    List<String> sentences;

    public NormalSentenceProvider() {
        sentences = new ArrayList<>();
        try {
            //get a list of all sentences from the NormalSentences.txt file
            sentences = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/NormalSentences.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTextToType() {
        Collections.shuffle(sentences); //shuffle the list of all words

        //return the first 20 sentences words
        return sentences.subList(0, Math.min(sentences.size(), 20));
    }

}