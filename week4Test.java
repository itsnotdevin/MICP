package solution;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class week4Test {
    
    public week4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testFindStringTrue() {
        System.out.println("* testFindStringPass() JUnit4Test: Testing true scenarios");
        //1.1 All words found with unused dictionary words..
        assertEquals(true, week4.findString("pear salmon you sun girl enjoy", "youenjoy"));
        //1.2 Repeating dictionary and word input..
        assertEquals(true, week4.findString("ab ab ab ab", "ababababababab"));
        //1.3 Two possible recursive solutions..
        assertEquals(true, week4.findString("pear salmon pearsalmon", "pearsalmon"));
        //1.4 Single letter dictionary input..
        assertEquals(true, week4.findString("a b c d e f g", "aaaaaaabcdefgaa"));
        //1.5 Backtracking to find a solution..
        assertEquals(true, week4.findString("apple tsunami pear flow flowmart twotwo", "pearflowmart"));
    }
    
    @Test
    public void testFindStringFalse() {
        System.out.println("* testFindStringFalse() JUnit4Test: Testing false scenarios");
        // 2.1 No words found..
        assertEquals(false, week4.findString("pear twice", "bob"));
        // 2.2 Some, but not all words found..
        assertEquals(false, week4.findString("pear bob", "bobsalty"));
        // 2.3 Empty string argument for dictionary..
        assertEquals(false, week4.findString("", "saltybob"));
        // 2.4 Empty string argument for word..
        assertEquals(false, week4.findString("pear, bob", ""));
        // 2.5 Empty string argument for both dictionary and word..
        assertEquals(false, week4.findString("", ""));
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        System.out.println("* testFindString() JUnit4Test: - Testing IllegalArgumentException");
        //1.1 null inputs..
        week4.findString(null, "word");
        week4.findString("dictionary, word", null);
        week4.findString(null, null);
    }
}
