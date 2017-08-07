/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Devin
 */
public class week3Test {
    
    public week3Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class week3.
     */
    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        Integer[] test = new Integer[2];
        
        System.out.println("* threePairsJUnit4Test: test method 1 - checkExpectedException()");
        week3.threePairs(null);
        week3.threePairs(test);
    }
}
