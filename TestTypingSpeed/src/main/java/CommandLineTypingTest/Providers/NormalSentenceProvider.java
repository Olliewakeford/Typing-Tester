package CommandLineTypingTest.Providers;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

/**
 * Provides normal sentences for the user to type in the typing test.
 * Normal sentences are sentences that make sense, making them relatively easier to type.
 */
public class NormalSentenceProvider implements TextToTypeProvider {
    List<String> sentences;

    /**
     * Constructs a new NormalSentenceProvider.
     * This constructor reads normal sentences from a file and stores them in a list.
     */
    public NormalSentenceProvider() {
        /**
         * The list of sentences for the normal sentence provider.
         */
        sentences = new ArrayList<>();

        try {
            //get a list of all sentences from the NormalSentences.txt file
            sentences = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/NormalSentences.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a list of 20 random normal sentences.
     *
     * @return a list of 20 random normal sentences
     */
    @Override
    public List<String> getTextToType() {
        Collections.shuffle(sentences); //shuffle the list of all sentences

        //return the first 20 sentences from the shuffled list
        return sentences.subList(0, Math.min(sentences.size(), 20));
    }

}