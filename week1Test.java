
package solution;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class week1Test {
    
    public week1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testWeek1() throws Exception {
        System.out.println("* JUnit4Test: - Testing negative/positive keys");
        //tests positive keys
        assertEquals("some text", week1.cipher("0:some text")); 
        assertEquals("tpnf ufyu", week1.cipher("1:some text"));
        assertEquals("222222", week1.cipher("1:111111"));
        assertEquals("bbbbbb", week1.cipher("1:aaaaaa"));
        assertEquals("$$$$$", week1.cipher("1:$$$$$"));
        assertEquals("AAAAA", week1.cipher("1:ZZZZZ"));
        assertEquals("00000", week1.cipher("1:99999"));
        // tests negative keys
        assertEquals("00000", week1.cipher("-1:11111"));
        assertEquals("AAAAA", week1.cipher("-1:BBBBB"));
        assertEquals("$$$$$", week1.cipher("-1:$$$$$"));
        assertEquals("99999", week1.cipher("-1:00000"));
        assertEquals("ZZZZZ", week1.cipher("-1:AAAAA"));
        
        // tests a few edge cases with weird spacing issues
        assertEquals(" tpnf ufyu", week1.cipher("1: some text"));
        assertEquals(" tpnf ufyu", week1.cipher("1 : some text"));
        assertEquals(" some text", week1.cipher(" -0 : some text"));

    }
    
    @Test (expected=Exception.class)
    public void checkArgumentException() throws Exception {
        System.out.println("* JUnit4Test: - Testing thrown Exception");
        week1.cipher("::");
        week1.cipher(null);
        week1.cipher("");
        week1.cipher("a: some text");
        week1.cipher("@:some text");
        week1.cipher("-:some text");
        week1.cipher("1:");
        week1.cipher("b");
        week1.cipher("0");
        week1.cipher("1");
    }

}
