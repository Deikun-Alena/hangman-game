package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Game game;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n\nДобро пожаловать в игру 'Виселица'!");
            System.out.println("---- Меню ----");
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            System.out.print("Введите свой выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n\nНеккоректное значение. Пожалуйта, введите цифру.");
                continue;
            }

            switch (choice) {
                case 1:
                    game = new Game(selectWord());
                    startGame();
                    game.printGameResult();
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
        while (game.getMistakesCount() < game.getMaxAttempts() && !game.isWordGuessed()) {
            game.printCurrentState();
            game.printHangman();
            var letter = inputLetter();
            game.processGuess(letter);
        }
    }

    //word
    public static String selectWord() {
        Path dictionaryPath = Paths.get("src/main/resources/dictionary.txt");

        try {
            if (!Files.exists(dictionaryPath)) {
                System.out.println("ОШИБКА: Файл словаря не найден!");
                return "";
            }

            List<String> words = Files.readAllLines(dictionaryPath);

            if (words.isEmpty()) {
                System.out.println("ОШИБКА: Словарь пуст!");
                return "";
            }

            String selectedWord = words.get(ThreadLocalRandom.current().nextInt(words.size()));
            System.out.print("\n\nСлово загадано! \nДлина слова: " + selectedWord.length() + "\n");
            return selectedWord.trim();
        } catch (IOException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
            return "";
        }
    }

    //letter
    public static char inputLetter() {
        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim();

            if(isValidLetter(input)) {
                return input.charAt(0);
            } else {
                System.out.println("Попробуйте снова!");
            }
        }
    }

    private static boolean isValidLetter(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("\n\nОШИБКА: Ввод не может быть пустым!");
            return false;
        }

        if (input.length() != 1) {
            System.out.println("\n\nОШИБКА: Нужно ввести одну букву!");
            return false;
        }

        char letter = input.charAt(0);
        if ((letter >= 'а') && (letter <= 'я') || (letter == 'ё')) {
            return true;
        } else {
            System.out.println("\n\nОШИБКА: Нужно ввести строчную русскую букву!");
            return false;
        }
    }
}