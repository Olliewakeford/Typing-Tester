package CommandLineTypingTest.Providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleWordsProvider implements TextToTypeProvider {
    List<String> words;

    //Constructor for SingleWordsProvider where int wordsType is the type of words to be provided
    //0 for random words
    //1 for nonsense words
    public SingleWordsProvider(int wordsType) {
        words = new ArrayList<>();
        try {
            if (wordsType == 0) {
                //get a list of all words from the RandomWords.txt file
                words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/RandomWords.txt"));
            }
            else if (wordsType == 1) {
                //get a list of all words from the Nonsense.txt file
                words = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/NonsenseWords.txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getTextToType() {
        Collections.shuffle(words); //shuffle the list of all words

        // Return only the first 1000 words, or the entire list if it has less than 1000 words
        return words.subList(0, Math.min(words.size(), 1000));
    }

}
