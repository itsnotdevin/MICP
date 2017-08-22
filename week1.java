package solution;

import java.util.Objects;

public class week1 {
    public static String cipher(String tmp) throws Exception {

        if (Objects.equals(tmp, null) || tmp.isEmpty()) 
            throw new Exception("week1(String) must be non empty and initialized");

        String[] word = tmp.split(":");
        if (word[0].length() == tmp.length()) 
            throw new Exception("missing : symbol");

        int key = getKey(word[0]);
        if (key == 0)
            return word[1];

        return shiftString(word, key);
    }
    
    private static int getKey (String word) throws Exception {
        word = word.trim();
        if (word.charAt(0) != '-' && !Character.isDigit(word.charAt(0))) throw new Exception("Special characters in key are not allowed");
        else {
            for (int i = 1; i < word.length(); i++) 
                if (Character.isLetter(word.charAt(i)) || !Character.isDigit(word.charAt(i))) 
                    throw new Exception("Key must be digits only");
        }
        return Integer.parseInt(word);
    }

    private static String shiftString (String[] message, int key){
        StringBuilder sb = new StringBuilder();	
        
        for (int j = 1; j < message.length; j++) {
            for (int i = 0; i < message[j].length(); i++) {  
                
                int n = (int)message[j].charAt(i);
                if (Character.isDigit((char)n)) {
                    if (n + key%10 < 48) sb.append((char)(n + key%10 + 10));
                    else if (n + key%10 > 57) sb.append((char)(n + key%10 - 10));
                    else sb.append((char)(n + key%10));
                    continue;
                }
                
                else if (Character.isLetter((char)n)){
                    if (Character.isUpperCase((char)n)) {
                        if (n + key%26 < 65) sb.append((char)(n + key%26 + 26));
                        else if (n + key%26 > 90) sb.append((char)(n + key%26 - 26));
                        else sb.append((char)(n + key%26));
                        continue;
                    }
                    
                    if (Character.isLowerCase((char)n)) {
                        if (n + key%26 < 97) sb.append((char)(n + key%26 + 26));
                        else if (n + key%26 > 122) sb.append((char)(n + key%26 - 26));
                        else sb.append((char)(n + key%26));
                        continue;
                    }
                }
                
                else sb.append((char)n);
            }
        }
        return sb.toString();
    }
}
