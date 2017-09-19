public class Transaction extends Machine {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    public void addPayment(double money) {
        this.balance += money;
    }
    public void setBalance(double amount){
        this.balance = amount;
    }
}
