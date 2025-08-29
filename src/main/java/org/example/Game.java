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

     public void addLetter(char letter) {
         if (usedLetters.contains(letter)) {
             System.out.println("\n\nВы уже пробовали эту букву!");
         }

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
             System.out.println("Отлично! Буква есть в слове.");
             System.out.println("Использованные буквы: " + usedLetters);
         } else {
             mistakesCount++;
             System.out.println("Такой буквы нет.");
             System.out.println("Использованные буквы: " + usedLetters);
             System.out.println("Ошибок: " + mistakesCount + " из " + maxAttempts);
         }
     }

     public void hangman() {
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