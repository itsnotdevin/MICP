public class Machine {
    Bank bank;
    Inventory inventory;
    Transaction transaction;
    protected double profit;
  
    Machine() {
        bank = new Bank();
        inventory = new Inventory();
        transaction = new Transaction();
        this.profit = 0;
    } 
    public void addPayment(double payment) {
        transaction.addPayment(payment);
    }
    public double cancelTransaction(){
        double tmp = transaction.getBalance();
        transaction.setBalance(0);
        return tmp;
    }
    public Item sellItem(String label) {
        if (isPaid(label)){
            Item tmp = inventory.dispenseItem(label);
            if (tmp != null){
                bank.updateReserve(tmp.getCost() - transaction.getBalance());
                transaction.addPayment(transaction.getBalance() - tmp.getCost());
                this.updateProfit(tmp.getCost());
                }
            return tmp;
        } else {
            System.err.println("Insufficient funds to dispense " + label+". Please add more funds");
            return null;
        }    
    }
    public boolean isPaid(String label){
        return (transaction.getBalance() >= inventory.dispenseItem(label).getCost());
    }
    public double getProfit() {
        return profit;
    }
    public void updateProfit(double amount) {
        profit += amount;
    }
}


