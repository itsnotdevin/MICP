/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParenthesisTest {
    
    public ParenthesisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetParens() {
        System.out.println("2 testGetParens() JUnit4Test: Testing (n >= 0) scenarios");
        List<String> list = new ArrayList<String>();
        
        // 2.1 getParens(n=0) returns an empty list.
        assertEquals(list, Parenthesis.getParens(0));
            
        // 2.2 getParens(n=1) returns a small list.
        list = Arrays.asList("()");
        assertEquals(list, Parenthesis.getParens(1));
        
        // 2.3 getParens(n=5) returns a larger list.
        list = Arrays.asList("((((()))))","(((()())))",
                             "(((())()))","(((()))())","(((())))()","((()(())))","((()()()))",
                             "((()())())","((()()))()","((())(()))","((())()())","((())())()",
                             "((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())",
                             "(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())",
                             "(()())()()","(())((()))","(())(()())","(())(())()","(())()(())",
                             "(())()()()","()(((())))","()((()()))","()((())())","()((()))()",
                             "()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()",
                             "()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"
                            );
        assertEquals(list, Parenthesis.getParens(5)); 
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        System.out.println("1 testParenthesis() JUnit4Test: - Testing (n <= 0) scenarios");
        // 1.1 n < 0 throws an exception
        Parenthesis.getParens(-1);
        // 1.2 n > 100 throws an exception
        Parenthesis.getParens(101);
    }
    
}
