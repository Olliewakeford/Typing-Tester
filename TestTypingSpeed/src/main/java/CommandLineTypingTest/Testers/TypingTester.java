package CommandLineTypingTest.Testers;

import CommandLineTypingTest.Result;

/**
 * Interface for different implementations of typing tests.
 * This interface provides a method to start a typing test and return a Result object.
 */
public interface TypingTester {
    /**
     * Starts the typing test and returns a Result object.
     *
     * @return the result of the typing test
     */
    Result startTest();
}