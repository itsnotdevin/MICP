import java.io.*;
import java.util.*;

public class week2
{
    public static void maain(String[] args)throws Exception {
        String word = "test1";
        System.out.println(lengthOfLongestSubstring(word));
        
    }
  private static int lengthOfLongestSubstring(String s)
  {
    if (s == null) throw new IOException("null string");
    if (s.length() <= 1) return s.length();

    int max = 0;
    HashSet<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < s.length(); i++)
    {
      if (!set.add((int)s.charAt(i)))
      {
        max = (max <= set.size() ? set.size() : max);
        set.clear();
        set.add((int)s.charAt(i));
      }
    }
    return max <= set.size() ? set.size() : max;
  }
}
