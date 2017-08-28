package solution;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class week5Test {
    
    public week5Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testIsPallindrome() {
        LL<Character> list = new LL<Character>();
       
       // testing list containing 1 and 2 elements.
       list.insertB('b');
       assertEquals(true, week5.isPallindrome(list));
       list.insertB('b');
       assertEquals(true, week5.isPallindrome(list));
       
       // testing list with special characters.
       list.insertF('$');
       list.insertB('$');
       assertEquals(true, week5.isPallindrome(list));
       list.insertF('@');
       assertEquals(false, week5.isPallindrome(list));
       list.insertB('@');
       
       // testing list with numbers.
       list.insertF('1');
       list.insertB('1');
       assertEquals(true, week5.isPallindrome(list));
       list.insertF('2');
       assertEquals(false, week5.isPallindrome(list));
       list.insertB('2');
       
       // testing different positive lengths for both true and false;;
       for (int i = 3; i < 50; i++){
            list = generateList(i,true);
            assertEquals(true, week5.isPallindrome(list));
       }
       for (int i = 3; i < 50; i++){
            list = generateList(i,false);
            assertEquals(false, week5.isPallindrome(list));
       }
       
       // testing empty and null lists 
       boolean result = false;
       try {
           week5.isPallindrome(null);
           week5.isPallindrome(list);
       } 
       catch (NullPointerException e){
           result = true;
       }
       assertEquals(true, result);
    }
    
    public static LL generateList(int targetSize, boolean isPallindrome){
        LL<Character> list = new LL<>();
        // true cases
        if (isPallindrome) {
            // True, even
            if (targetSize %2 == 0) {
                for (int i = 0; i < targetSize/2; i++)
                    list.insertB((char)('a' + (int)i));
                for (int i = 0; i < targetSize/2; i++)
                    list.insertF((char)('a' + (int)i)); 
            }
            // True, odd
            else {
                for (int i = 0; i < targetSize/2; i++)
                    list.insertB((char)('a' + (int)i));
                list.insertF('#');
                for (int i = 0; i < targetSize/2; i++)
                    list.insertF((char)('a' + (int)i));
            }
        }
        else {
            //false even
            if (targetSize %2 == 0) {
                for (int i = 0; i < (targetSize/2)-1; i++)
                    list.insertB((char)('a' + (int)i));
                for (int i = 0; i < (targetSize/2)-1; i++)
                    list.insertF((char)('a' + (int)i)); 
                list.insertF('F');
                list.insertF('D'); 
            }
            //false odd
            else {    
                for (int i = 0; i < targetSize/2; i++)
                    list.insertF((char)('a' + (int)i));
                for (int i = 0; i < targetSize/2; i++)
                    list.insertB((char)('a' + (int)i));
                list.insertB('D');        
            }
        }
        return list;
    }
}
