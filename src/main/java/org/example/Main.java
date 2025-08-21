package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean running = true;

        while (running) {
            System.out.println("\nДобро пожаловать в игру 'Виселица'!");
            System.out.println("\n--- Меню ---");
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            System.out.print("Введите свой выбор: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неккоректное значение. Пожалуйта, введите цифру.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали начать игру.");
                    game.play();
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