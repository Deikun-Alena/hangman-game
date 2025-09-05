package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int mistakesCount = 0;
    private final int maxAttempts = 6;
    private final String selectedWord;
    private String currentState;
    private static final String HIDDEN_LETTER_MASK = "_";
    private final List <Character> usedLetters = new ArrayList<>();

    public Game(String selectedWord) {
        this.selectedWord = selectedWord;
        this.currentState = HIDDEN_LETTER_MASK.repeat(selectedWord.length());
    }

    public void printCurrentState() {
        System.out.println("Загаданное слово: " + currentState);
    }

    private boolean isLetterUsed(char letter) {
        return usedLetters.contains(letter);
    }

    private List<Integer> updateState(char letter) {
        usedLetters.add(letter);

        ArrayList<Integer> matchedLetters = new ArrayList<>();

        for (int i = 0; i < selectedWord.length(); i++) {
            if (letter == selectedWord.charAt(i)) {
                matchedLetters.add(i);
            }
        }

        if (!matchedLetters.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(currentState);

            for (int i : matchedLetters) {
                stringBuilder.setCharAt(i, letter);
            }

            currentState = stringBuilder.toString();
        } else {
            mistakesCount++;
        }
        return matchedLetters;
    }

    private void printGuessResult(List<Integer> matchedLetters) {
        if (!matchedLetters.isEmpty()) {
            System.out.println("\nОтлично! Буква есть в слове.");
        } else {
            System.out.println("\nТакой буквы нет.");
        }
        System.out.println("Использованные буквы: " + usedLetters);
        System.out.println("Ошибок: " + mistakesCount + " из " + maxAttempts);
    }

    public void processGuess(char letter) {
        if (isLetterUsed(letter)) {
            System.out.println("\n\nВы уже пробовали эту букву!");
            return;
        }

        List<Integer> indices = updateState(letter);
        printGuessResult(indices);
    }

    public void printGameResult() {
        if (isWordGuessed()) {
            System.out.println("\n\nПоздравляю! Вы отгадали слово: " + getSelectedWord());
        } else {
            System.out.println("\n\nИгра окончена. Загаданное слово было: " + getSelectedWord());
        }
    }

    public final String[] HANGMAN_STAGES = new String[] {
        """
        +---+
        |   |
        |
        |
        |
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |
        |
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |   |
        |
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |  /|
        |
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |  /|\\
        |
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |  /|\\
        |  /
        |
        =========
        """,

        """
        +---+
        |   |
        |   O
        |  /|\\
        |  / \\
        |
        =========
        """,
    };

    public void printHangman() {
        if (mistakesCount >= 0 && mistakesCount < HANGMAN_STAGES.length) {
            System.out.println(HANGMAN_STAGES[mistakesCount]);
        }
        else if (mistakesCount >= HANGMAN_STAGES.length) {
            System.out.println(HANGMAN_STAGES[HANGMAN_STAGES.length - 1]);
        }
    }

    public boolean isWordGuessed() {
        return !currentState.contains("_");
    }

    public int getMistakesCount() {
        return mistakesCount;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getSelectedWord() {
        return selectedWord;
    }
}