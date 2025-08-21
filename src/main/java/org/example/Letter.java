package org.example;

import java.util.Scanner;

public class Letter {
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        String input = scanner.nextLine();
        validate(input);
        scanner.close();
    }

    private void validate(String  input) {
        if (input.length() == 1) {
            char letter = input.charAt(0);

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
