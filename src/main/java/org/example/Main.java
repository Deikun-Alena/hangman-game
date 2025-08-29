package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n\nДобро пожаловать в игру 'Виселица'!");
            System.out.println("---- Меню ----");
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            System.out.print("Введите свой выбор: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n\nНеккоректное значение. Пожалуйта, введите цифру.");
                continue;
            }

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    System.out.println("\nВыход из игры. Досвидания!");
                    running = false;
                    break;
                default:
                    System.out.println("\n\nНеккоректный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
        scanner.close();
    }

    public static void startGame() {
        Game game = new Game(selectWord());
        while (game.getMistakesCount() < game.getMaxAttempts() && !game.isWordGuessed()) {
            game.printCurrentState();
            game.hangman();
            var letter = inputLetter();
            game.addLetter(letter);
        }

        if (game.isWordGuessed()) {
            System.out.println("\n\nПоздравляю! Вы отгадали слово: " + game.getSelectedWord());
        } else {
            System.out.println("\n\nИгра окончена. Загаданное слово было: " + game.getSelectedWord());
        }
    }

    //word
    public static String selectWord() {
        try {
            List<String> words = Files.readAllLines(Paths.get("src/main/resources/dictionary.txt"));
            String selectedWord = words.get(ThreadLocalRandom.current().nextInt(words.size()));
            System.out.print("\n\nСлово загадано! \nДлина слова: " + selectedWord.length() + "\n");
            return selectedWord.trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //letter
    public static char inputLetter() {
        System.out.print("Введите букву: ");
        String input = scanner.nextLine();
        validate(input);
        return input.charAt(0);
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("\n\nОШИБКА: Ввод не может быть пустым!");
            return;
        }

        if (input.length() == 1) {
            char letter = input.charAt(0);

            if (letter >= 'а' && letter <= 'я') {
                System.out.println(" ");
            } else {
                System.out.println("\n\nОШИБКА: Нужно ввести строчную русскую букву!");
            }

        } else {
            System.out.println("\n\nОШИБКА: Нужно ввести одну букву!");
        }
    }
}