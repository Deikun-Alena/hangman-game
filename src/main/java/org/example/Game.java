package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int mistakesCount = 0;
    private final int maxAttempts = 6;
    private String selectedWord;
    private String currentState;
    private List <Character> usedLetters = new ArrayList<>();

    public Game(String selectedWord) {
        this.selectedWord = selectedWord;
        this.currentState = "_".repeat(selectedWord.length());
    }

    public void printCurrentState() {
        System.out.println("Загаданное слово: " + currentState);
    }

    private boolean isLetterUsed(char letter) {
        return usedLetters.contains(letter);
    }

    private List<Integer> updateState(char letter) {
        usedLetters.add(letter);

        ArrayList<Integer> occurrenceIndices = new ArrayList<>();
        for (int i = 0; i < selectedWord.length(); i++) {
            if (letter == selectedWord.charAt(i)) {
                occurrenceIndices.add(i);
            }
        }

        if (!occurrenceIndices.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(currentState);
            for (int i : occurrenceIndices) {
                stringBuilder.setCharAt(i, letter);
            }
            currentState = stringBuilder.toString();
        } else {
            mistakesCount++;
        }
        return occurrenceIndices;
    }

    private void printGuessResult(List<Integer> occurrenceIndices, char letter) {
        if (!occurrenceIndices.isEmpty()) {
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
        printGuessResult(indices, letter);
    }

    public void printGameResult() {
        if (isWordGuessed()) {
            System.out.println("\n\nПоздравляю! Вы отгадали слово: " + getSelectedWord());
        } else {
            printLastHangman();
            System.out.println("\n\nИгра окончена. Загаданное слово было: " + getSelectedWord());
        }
    }

    public void printHangman() {
        if (mistakesCount == 0) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("=========");
        }

        if (mistakesCount == 1) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("=========");
        }

        if (mistakesCount == 2) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|   |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("=========");
         }

        if (mistakesCount == 3) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|  /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("=========");
        }

        if (mistakesCount == 4) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|  /|\\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("=========");
        }

        if (mistakesCount == 5) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|  /|\\");
            System.out.println("|  /");
            System.out.println("|");
            System.out.println("=========");
        }
    }

    public void printLastHangman() {
        if (mistakesCount == 6) {
            System.out.println("+---+");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|  /|\\");
            System.out.println("|  / \\");
            System.out.println("|");
            System.out.println("=========");
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