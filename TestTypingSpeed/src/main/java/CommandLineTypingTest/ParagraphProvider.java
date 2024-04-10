package CommandLineTypingTest;

import java.util.List;

//Interface for different implementations of sentences for user to type
public interface ParagraphProvider {
    List<String> getSentences();
}