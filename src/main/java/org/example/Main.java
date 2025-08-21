package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            // Display menu options
            System.out.println("\nДобро пожаловать в игру 'Виселица'!");
            System.out.println("\n--- Меню ---");
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            System.out.print("Введите свой выбор: ");

            // Get user input
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неккоректное значение. Пожалуйта, введите цифру.");
                continue;
            }

            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали начать игру.");
                    // Call method for Option A
                    break;
                case 2:
                    System.out.println("Выход из игры. Досвидания!");
                    running = false;
                    break;
                default:
                    System.out.println("Неккоректный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }

        scanner.close();
    }
}