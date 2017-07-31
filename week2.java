package solution;
import java.io.*;
import java.util.*;

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
        int maxLength = 0;
            
        for (int i = 0; i < s.length(); i++) 
        {  
            if (!asciiSet.add((int)s.charAt(i))) 
            {
                maxLength = (maxLength <= asciiSet.size() ? asciiSet.size() : maxLength);
                i -= asciiSet.size();   
                asciiSet.clear();
            }
        }

        return  maxLength = (maxLength <= asciiSet.size() ? asciiSet.size() : maxLength);   
    }
}

