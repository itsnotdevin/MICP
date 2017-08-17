import org.junit.Test;
import static org.junit.Assert.*;

public class week4 {
    public static boolean findString(String dict, String word) throws IllegalArgumentException
    {
        if (dict == null || word == null) throw new IllegalArgumentException("An attempt was made to call findString(String dict, String word) with a null reference to either dict or word arguments.");
        if (dict.isEmpty() || word.isEmpty()) return false;
        String[] parsedDict = dict.split("\\s+");
        return findString(parsedDict, word);
    }

    private static boolean findString(String[] dict, String word)
    {
        if (word.length() == 0) return true;
        for (int i = 0; i < dict.length; i++)
        {
            if (dict[i].length() > word.length()) continue;
            if (word.substring(0,dict[i].length()).equalsIgnoreCase(dict[i]))
                return findString(dict, word.substring(dict[i].length(),word.length()));
        }
       return false;
    }

    @Test
        public void testFindString() {
            System.out.println("* testFindString JUnit4Test: test method 1 - assertEquals()");
            //Test cases for true output: all words found w/ extra dictionary input, repeating words found, different ways to pass,
            // one letter dictionary inputs, repeating dictionary input, one word dictionary and word
            assertEquals(true, week4.findString("pear salmon you sun girl enjoy", "youenjoy"));
            assertEquals(true, week4.findString("pear salmon you sun", "youyouyouyou"));
            assertEquals(true, week4.findString("pear salmon pearsalmon", "pearsalmon"));
            assertEquals(true, week4.findString("a b c d e f g", "aaaaaaabcdefgaa"));
            assertEquals(true, week4.findString("ab ab ab ab", "ababababababab"));
            assertEquals(true, week4.findString("pear", "pear"));

            //Test cases for false output: no words found, false at end, false at beginning,one word dictionary and word
            //empty dictionary, empty word, empty word and dictionary
            assertEquals(false, week4.findString("pear twice", "bob"));
            assertEquals(false, week4.findString("pear bob", "bobsalty"));
            assertEquals(false, week4.findString("pear bob", "saltybob"));
            assertEquals(false, week4.findString("pear", "bob"));
            assertEquals(false, week4.findString("", "saltybob"));
            assertEquals(false, week4.findString("pear bob", ""));
            assertEquals(false, week4.findString("", ""));

        }
        @Test (expected=IllegalArgumentException.class)
        public void checkArgumentException() {
            System.out.println("* testFindString JUnit4Test: test method 2 - checkArgumentException()");
            //Test cases for exception: null dictionary, null word, null dictionary and word,
            week4.findString(null, "word");
            week4.findString("dictionary word", null);
            week4.findString(null, null);
        }

}
