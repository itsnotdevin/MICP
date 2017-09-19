import org.junit.Test;
import static org.junit.Assert.*;

public class MachineTest {
    Machine testMachine = new Machine();
    
    public MachineTest() {
    }

    @Test
    public void testVendingMachine() {
        System.out.println("JUnit test vending machine methods");
        
        // adding a payment
        assertEquals(true, testMachine.transaction.getBalance() == 0);
        testMachine.transaction.addPayment(1);
        assertEquals(true, testMachine.transaction.getBalance() == 1);
        
        // getting change, and canceling a transaction
        assertEquals(true, testMachine.cancelTransaction() == 1);
        assertEquals(true, testMachine.transaction.getBalance() == 0);
        
        // create items
        Item soda = new Item("Coke", 1);
        Item chips = new Item("Cheetos", 0);
        
        // stock inventory with items.
        testMachine.inventory.stockItem(soda, 2);
        testMachine.inventory.stockItem(chips, 1);
        
        // sufficient funds and inventory
        assertEquals(new Item("Coke", 1), testMachine.sellItem("Coke"));
        assertEquals(new Item("Cheetos", 0), testMachine.sellItem("Cheetos"));
        
        // sufficient funds, no inventory
        assertEquals(true, testMachine.sellItem("Cheetos") == null);
        
        // inventory, no funds
        assertEquals(true, testMachine.sellItem("Coke") == null);
        
        // get profit
        assertEquals(true, testMachine.getProfit() == 1);
        
    }
}
