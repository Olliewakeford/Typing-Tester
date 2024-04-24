package CommandLineTypingTest.Providers;

import java.util.List;

/**
 * Interface for different implementations of sentences for user to type.
 * This interface provides a method to get a list of strings for the user to type.
 */
public interface TextToTypeProvider {
    /**
     * Returns a list of strings for the user to type.
     *
     * @return a list of strings for the user to type
     */
    List<String> getTextToType();
}