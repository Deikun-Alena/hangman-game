package org.example;

import java.util.Scanner;

public class InputWord {

    // Введение буквы игроком
    public void inputWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        String input = scanner.nextLine();
        Validate(input);
        scanner.close();
    }

    private void Validate(String  input) {

        // Проверяем, что введена одна буква
        if (input.length() == 1) {
            char letter = input.charAt(0);

            // Проверяем, что введена русская буква
            if ((letter >= 'А' && letter <= 'Я') || (letter >= 'а' && letter <= 'я')) {
                System.out.println("Вы ввели букву: "  + letter);
            } else {
                System.out.println("ОШИБКА: нужно ввести русскую букву!");
            }

        } else {
            System.out.println("ОШИБКА: нужно ввести одну букву!");
        }
    }
}
