package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordSelector {
    private static String selectedWord; // фиксированное слово

    // Загадывание слова программой
    public void selectWord() throws IOException {
        try {
            // Read all lines into a List<String>
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/dictionary.txt"));

            // Convert List<String> to String[]
            String[] words = lines.toArray(new String[0]);

            // Выбираем слово один раз и сохраняем
            selectedWord = words[ThreadLocalRandom.current().nextInt(words.length)];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
