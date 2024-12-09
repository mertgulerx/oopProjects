package RecipeSearchEngine;

import java.util.ArrayList;

public class Recipe {
    private final ArrayList<String> lines;

    public Recipe(){
        lines = new ArrayList<>();
    }

    public void add(String string){
        lines.add(string);
    }

    public void list(){
        System.out.println(lines.get(0) + ", cooking time: " + lines.get(1));
    }

    public boolean searchName(String word){
        if (lines.get(0).contains(word)){
            return true;
        }
        return false;
    }

    public boolean searchTime(int time){
        if(Integer.valueOf(lines.get(1)) <= time){
            return true;
        }
        return false;
    }

    public boolean searchIngredient(String word){
        for (int i = 2; i < lines.size(); i++){
            if (lines.get(i).equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }

}

