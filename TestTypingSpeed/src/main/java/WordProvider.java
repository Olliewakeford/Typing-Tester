package main.java;

import java.util.List;

//Interface for different implementations of words for user to type
public interface WordProvider {
    List<String> getWords();
}