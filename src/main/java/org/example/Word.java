package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Word {
    private static String selectedWord;

    public void select() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/dictionary.txt"));
            String[] words = lines.toArray(new String[0]);
            selectedWord = words[ThreadLocalRandom.current().nextInt(words.length)];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
