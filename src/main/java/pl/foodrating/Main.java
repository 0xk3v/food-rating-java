package pl.foodrating;

import java.util.InputMismatchException;
import java.util.Scanner;

import pl.foodrating.utils.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n======================================");
        System.out.println("Welcome to Food outlets rating system");

        boolean appState = true;

        // Creating Menu
        Menu menu = new Menu();
        int choice;

        menu.addOption("Load data from file");
        menu.addOption("View Restaurants, Take-away shops");
        menu.addOption("Add Restaurants, Take-away shops");
        menu.addOption("Add rating");
        menu.addOption("Quit application");

        Scanner scanner = new Scanner(System.in);

        do {
            menu.display();
            try {
                choice = scanner.nextInt();
                if (choice == 5) {
                    appState = false;
                }
            } catch (InputMismatchException e) {
                appState = false;
                System.err.println("Invalid input!!");
                System.err.println("Please use numbers to indicate your choice\n");

            } catch (Exception e) {
                System.err.println(e);
            }

        } while (appState);
        scanner.close();
    }
}