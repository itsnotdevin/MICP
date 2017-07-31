package solution;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class week2Test {
    public week2Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Test
    public void LLCSSTest() {
        System.out.println("* LCSSJUnit4Test: test method 1 - assertEquals()");
        assertEquals(3, week2.lengthOfLongestSubstring("abc"));   
        assertEquals(4, week2.lengthOfLongestSubstring("test1"));
        
        assertEquals(2, week2.lengthOfLongestSubstring("aA"));
        assertEquals(2, week2.lengthOfLongestSubstring("A1"));
        assertEquals(2, week2.lengthOfLongestSubstring("1A"));
        assertEquals(1, week2.lengthOfLongestSubstring("b"));
        
        assertEquals(1, week2.lengthOfLongestSubstring("1"));
        assertEquals(2, week2.lengthOfLongestSubstring("100"));
        assertEquals(2, week2.lengthOfLongestSubstring("001"));
       
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        System.out.println("* LCSSJUnit4Test: test method 2 - checkExpectedException()");
        week2.lengthOfLongestSubstring(null);
    }
    
}
