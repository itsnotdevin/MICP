package solution;
import java.util.HashMap;

public class week4 {

    public static boolean findString(String dict, String word) throws IllegalArgumentException {
        if (dict == null || word == null) throw new IllegalArgumentException("findString(String, String) called with null argument references.");
        if (dict.isEmpty() || word.isEmpty()) return false;
        
        String[] parsedDict = dict.split("\\s+");  
        return findString(parsedDict, word, new HashMap<String, Integer>(), false);
        
    }

    private static boolean findString(String[] dict, String word, HashMap map, boolean flag) {
        
        // Base case
        if ( flag || word.length() == 0) return true;
           
        for (Integer i = 0; i < dict.length; i++) {   
            
            // making sure to avoid array out of bounds on next line. 
            if (dict[i].length() <= word.length()) { 
                
                // Note: just using 'tmp' to make the rest of the method easier to read.
                String tmp = word.substring(0,dict[i].length());
                
                // We've seen this state before when the map key and value matches the current substring and index.
                if (i.equals(map.get(tmp))) continue;
                if (tmp.equalsIgnoreCase(dict[i])) {          
                    flag = findString(dict, word.substring(dict[i].length(),word.length()), map, flag);
                    
                    //save bad state.
                    map.put(tmp, i);
                }      
            }           
        }
        return flag;
    }
}
