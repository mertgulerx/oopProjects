
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<Data> list = new ArrayList<>();


        try (Scanner scanner = new Scanner(Paths.get("literacy.csv"))){
            while (scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] parts = row.split(",");
                
                Data data = new Data(parts[3], parts[2].replace("(%)", "").trim(), Integer.parseInt(parts[4]), Float.parseFloat(parts[5].trim()));
                list.add(data);                
            }

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }


        Collections.sort(list);
        list.stream().forEach(data -> System.out.println(data));


    }
}
