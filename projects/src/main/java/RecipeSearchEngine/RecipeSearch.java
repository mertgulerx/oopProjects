package RecipeSearchEngine;


import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader recipes = new FileReader();

        while (true) {
            System.out.println("File to read: ");
            String fileName = scanner.nextLine();
            if (fileName.isEmpty()) {
                System.out.println("Filename cant be empty.");
                continue;
            }

            if (!(recipes.read(fileName))) {
                continue;
            }

            recipes.add(fileName);
            System.out.println("\nCommands:\n" + //
                    "list - lists the recipes\n" + //
                    "stop - stops the program\n" + //
                    "find name - searches recipes by name\n" + //
                    "find cooking time - searches recipes by cooking time\n" + //
                    "find ingredient - searches recipes by ingredient");
            break;
        }

        while (true) {
            System.out.println("\nEnter command: ");
            String cmd = scanner.nextLine();
            if (cmd.equals("list")) {
                System.out.println("\nRecipes: ");

                recipes.listAll();
            } else if (cmd.equalsIgnoreCase("find name")) {
                System.out.println("Searched word: ");
                String word = scanner.nextLine();

                System.out.println("\nRecipes: ");

                recipes.searchName(word);
            } else if (cmd.equalsIgnoreCase("find cooking time")) {
                System.out.println("Max cooking time: ");
                int time = Integer.valueOf(scanner.nextLine());

                System.out.println("\nRecipes: ");
                recipes.searchTime(time);
            } else if (cmd.equalsIgnoreCase("find ingredient")) {
                System.out.println("Ingredient: ");
                String word = scanner.nextLine();

                System.out.println("\nRecipes: ");

                recipes.searchIngredient(word);
            } else if (cmd.equalsIgnoreCase("stop")){
                break;
            } else {
                System.out.println("Command not found");
            }

        }
    }

}

