package CommandLineTypingTest.Providers;


import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Implementation of TextToTypeProvider to provide normal sentences for user to type
// Normal sentences are sentences that make sense, making them relatively easier to type
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

    //Return a list of 20 normal sentences
    @Override
    public List<String> getTextToType() {
        Collections.shuffle(sentences); //shuffle the list of all sentences

        //return the first 20 sentences from the shuffled list
        return sentences.subList(0, Math.min(sentences.size(), 20));
    }

}