public class Bank extends Machine {
    private double reserve;
    public double getReserve(){
        return reserve;
    }
    public void updateReserve(double amount) {
        reserve += amount;
        super.updateProfit(amount);
    }
}
