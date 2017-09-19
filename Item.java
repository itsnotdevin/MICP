public class Item extends Inventory {
    private double cost;
    private String label;
    
    Item (String label, double cost) {
        this.label = label;
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    
}
