import java.util.ArrayList;
import java.util.HashMap;

public class Inventory extends Machine {
    int maxInventory;
    HashMap<String,ArrayList<Item>> Items;
    Inventory() {
        maxInventory = 0;
        Items = new HashMap<>();
    }
    
    public void stockItem(Item item, int quantity) {
        if (Items.get(item.getLabel()) != null) {
            for (int i = 0; i < quantity; i++){
                Item tmp = Items.get(item.getLabel()).get(0);
                Items.get(item.getLabel()).add(tmp); 
            }
        }
        else {
            ArrayList<Item> tmplist = new ArrayList<>();
            for (int i = 0; i < quantity; i++){
                tmplist.add(item);
                Items.put(item.getLabel(), tmplist);
            }
        }
    }
    
    public Item dispenseItem(String selection) {
        if (Items.containsKey(selection)){
            Item tmp = Items.get(selection).get(0);
            Items.get(selection).remove(0);
            return tmp;
        }
        else { 
            System.err.println("Vending Machine is sold out of " + selection + " please make another selection."); 
            return null;
        }
    }
}
