package CommandLineTypingTest.Providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GivenTopicTextToTypeProvider implements TextToTypeProvider {
    int topic;
    public GivenTopicTextToTypeProvider(int topic) {
        this.topic = topic;

    }

    //Return paragraph as a string
    @Override
    public List<String> getTextToType() {
        List<String> paragraph = new ArrayList<>(); //List containing one paragraph of text
        String fileName = convertKeyToFileName(topic);
        String path = "/resources/" + fileName;
        System.out.println("Path: " + path);
        try {
            //get a list of all sentences from the NormalSentences.txt file
            paragraph = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/resources/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraph;
    }

    private String convertKeyToFileName(int key) {
        return switch (key) {
            case 1 -> "Topic1Paragraph.txt";
            case 2 -> "Topic2Paragraph.txt";
            default -> "NormalSentences.txt";
        };
    }
}
