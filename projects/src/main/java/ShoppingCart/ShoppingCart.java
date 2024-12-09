import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items = new HashMap<>();;

    public void add(String product, int price){
        Item item = new Item(product, 1, price);
        if(!(items.containsKey(product))){
            items.put(product, item);
        } else {
            item = items.get(product);
            item.increaseQuantity();
            items.put(product, item);
        }
    }

    public int price(){
        int price = 0;
        for (Item item: items.values()){
            price += item.price();
        }
        return price;
    }

    public void print(){
        for (Item item: items.values()){
            System.out.println(item.toString() + " piece");
        }
    }
}
