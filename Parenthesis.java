package solution;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public static List<String> getParens(int n) {
        List<String> list = new ArrayList<String>();
        
        if (n == 0) return list; 
        if (n < 0 || n > 100) throw new IllegalArgumentException("Proper usage: getParens(int n), where 100 < n < 0");
        
        parenthesis(new StringBuilder("("), list, n-1, n);
        return list;
    }

    private static void parenthesis (StringBuilder sb, List<String> list, int left, int right) {
        
        // Base case.
        if (left == 0 && right == 0)
            if (!list.contains(sb.toString()))
                list.add(sb.toString()); 
        
        // We can always add left brackets up until we have n amount.
        if (left > 0) {
            parenthesis(sb.append("("), list, left-1, right);
            
            // Backtracking
            sb.setLength(sb.length()-1);
        }
        
        // We only right brackets when there is an open left bracket. 
        if (left < right){ 
            parenthesis(sb.append(")"), list, left, right-1);
            // Backtracking
            sb.setLength(sb.length()-1);
        }  
    }
}
