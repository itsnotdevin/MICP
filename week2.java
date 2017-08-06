import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class week2
{
 public static int lengthOfLongestSubstring(String s) throws IllegalArgumentException
    {
        if (s == null) throw new IllegalArgumentException();

        if (s.length() <= 1)
        {
            return s.length();
        }

        HashSet<Integer> asciiSet = new HashSet<Integer>();
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) throw new IllegalArgumentException();

            if (!asciiSet.add((int)s.charAt(i)))
            {
                maxLength = (maxLength <= asciiSet.size() ? asciiSet.size() : maxLength);
                i -= (asciiSet.size());
                asciiSet.clear();
            }
        }

        return  maxLength = (maxLength <= asciiSet.size() ? asciiSet.size() : maxLength);
    }

    @Test
    public void LLCSSTest() {
        System.out.println("* LCSSJUnit4Test: test method 1 - assertEquals()");
        assertEquals(3, week2.lengthOfLongestSubstring("abc"));
        assertEquals(4, week2.lengthOfLongestSubstring("test1"));
        assertEquals(3, week2.lengthOfLongestSubstring("abcabcabc"));
        assertEquals(2, week2.lengthOfLongestSubstring("aA"));
        assertEquals(2, week2.lengthOfLongestSubstring("A1"));
        assertEquals(2, week2.lengthOfLongestSubstring("1A"));
        assertEquals(1, week2.lengthOfLongestSubstring("a"));
        assertEquals(1, week2.lengthOfLongestSubstring("aaaaa"));
        assertEquals(1, week2.lengthOfLongestSubstring("1"));
        assertEquals(2, week2.lengthOfLongestSubstring("100"));
        assertEquals(2, week2.lengthOfLongestSubstring("001"));
        assertEquals(0, week2.lengthOfLongestSubstring(""));
        assertEquals(1, week2.lengthOfLongestSubstring("1111"));
    }

    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        System.out.println("* LCSSJUnit4Test: test method 2 - checkExpectedException()");
        week2.lengthOfLongestSubstring(null);
        week2.lengthOfLongestSubstring(" ");
        week2.lengthOfLongestSubstring("$");
    }
}
