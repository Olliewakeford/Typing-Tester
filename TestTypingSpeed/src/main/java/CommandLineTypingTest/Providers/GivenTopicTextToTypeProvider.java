package CommandLineTypingTest.Providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a paragraph of text on a specified Java topic for the typing test.
 */
public class GivenTopicTextToTypeProvider implements TextToTypeProvider {
    /**
     * The topic for the given text to type provider.
     */
    int topic;

    /**
     * Constructs a new GivenTopicTextToTypeProvider with the specified topic.
     *
     * @param topic index for the topic of the paragraph
     */
    public GivenTopicTextToTypeProvider(int topic) {
        this.topic = topic;
    }

    /**
     * Returns a paragraph of text on the specified Java topic.
     *
     * @return a list of a single string representing the paragraph.
     */
    @Override
    public List<String> getTextToType() {
        List<String> paragraph = new ArrayList<>(); //List containing one paragraph of text
        String fileName = convertKeyToFileName(topic);
        String path = "/resources/JavaParagraphs/" + fileName;

        try {
            //get a list of all sentences from the file with the respective topic name
            paragraph = Files.readAllLines(Paths.get(System.getProperty("user.dir") + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraph;
    }

    /**
     * Converts the topic key to the corresponding file name.
     *
     * @param key the topic key
     * @return the file name corresponding to the topic key
     */
    private String convertKeyToFileName(int key) {
        return switch (key) {
            case 1 -> "JavaOverview.txt";
            case 2 -> "ReflectionAPI.txt";
            case 3 -> "JavaPlatform.txt";
            case 4 -> "Generics.txt";
            case 5 -> "Annotations.txt";
            case 6 -> "ClassLoaders.txt";
            case 7 -> "ServiceLoaders.txt";
            case 8 -> "Bytecode.txt";
            case 9 -> "JNI.txt";
            case 10 -> "JNA.txt";
            case 11 -> "ForeignFunctions.txt";
            default -> "JavaOverview.txt";
        };
    }
}
