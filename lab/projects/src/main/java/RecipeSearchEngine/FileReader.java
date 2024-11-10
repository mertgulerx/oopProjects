package RecipeSearchEngine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private ArrayList<Recipe> recipes;

    public FileReader(){
        recipes = new ArrayList<>();
    }

    public boolean read(String fileName){
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            if (scanner.hasNextLine()){
                return true;
            }
        } catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
        return false;
    }

    public boolean add(String fileName){
        Recipe recipe = new Recipe();
        try (Scanner scanner = new Scanner(Paths.get(fileName))){
            while (scanner.hasNextLine()){
                String row = scanner.nextLine();
                if (row.equals("")){
                    recipes.add(recipe);
                    recipe = new Recipe();
                    continue;
                }

                recipe.add(row);
            }

            recipes.add(recipe);
            return true;
        } catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
        return false;
    }

    public void listAll(){
        for (Recipe recipe: recipes){
            recipe.list();
        }
    }

    public void searchName(String word){
        for (Recipe recipe: recipes){
            if(recipe.searchName(word)){
                recipe.list();
            }
        }

    }

    public void searchTime(int time){
        for (Recipe recipe: recipes){
            if(recipe.searchTime(time)){
                recipe.list();
            }
        }
    }

    public void searchIngredient(String word){
        for (Recipe recipe: recipes){
            if(recipe.searchIngredient(word)){
                recipe.list();
            }
        }
    }
}

