import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse(){
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock){
        prices.putIfAbsent(product, price);
        stocks.putIfAbsent(product, stock);
    }

    public int price(String product){
        if (prices.containsKey(product)){
            return prices.get(product);
        }
        return -99;
    }

    public int stock(String product){
        if (stocks.containsKey(product)){
            return stocks.get(product);
        }

        return 0;
    }

    public boolean take(String product){
        if (!(stocks.containsKey(product))){
            return false;
        }

        int stock = stocks.get(product);
        if (stock > 0){
            stocks.put(product, stock - 1);
            return true;
        }

        return false;
    }


    public Set<String> products(){
        Set<String> set = new HashSet<>();
        for (String key: prices.keySet()){
            set.add(key);
        }
        return set;
    }
    


}
