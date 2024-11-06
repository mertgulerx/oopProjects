package restaurant;

import restaurant.TableManager.TableManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableManager tableManager = new TableManager(4);
        UserInterface ui = new UserInterface(scanner, tableManager);
        ui.start();
    }
}