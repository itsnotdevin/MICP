
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class week1
{

  public static void main(String[] args) throws Exception
  {
    FileReader fileReader = null;
    BufferedReader buffReader = null;

    try
    {
      StringBuilder sb = new StringBuilder();
      String tmp = null;
      int endOfKey = -1;
      int shiftAmount = -1;
      fileReader = new FileReader("sample.csv");
      buffReader = new BufferedReader(fileReader);

      while ((tmp = buffReader.readLine()) != null)
      {
        char[] chars = tmp.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
          if (Character.isLetter(chars[i]))
          {
            System.err.println("\"" + tmp + "\".  Letter found in Key. Key must represent an integer between -1000000 and 1000000.");
            System.exit(-1);
          }
          // Edge Case #1 if a character in a key does not represent a digit,
          // and the character is not a semicolon or a minus symbol at the beginning of the key.
          if (!Character.isDigit(chars[i]))
          {
            if ((chars[i] == '-' && i != 0) && chars[i] != ':')
            {
              System.err.println("\"" + tmp + "\".  Symbol found in Key. Cipher key must represent an integer between -1000000 and 1000000.");
              System.exit(-1);
            }
          }
          if (chars[i] == ':')
          {
            // Edge Case #2 (created by method of parsing) strings beginning with -: are allowed through.
            if (tmp.substring(0,i) == "-")
            {
              System.err.println("\"" + tmp + "\".  Cipher key must represent an integer between -1000000 and 1000000.");
              System.exit(-1);
            }
            endOfKey = i;
            break;
          }
        }

      if (endOfKey < 1)
      {
        System.err.println("\"" + tmp + "\".  No missing key. Missing cipher key.");
        System.exit(-1);
      }


      shiftAmount = Integer.parseInt(tmp.substring(0,endOfKey));
      // if cipher key is 0, no need to apply a cipher.
      if (shiftAmount == 0)
      {
        System.out.println(chars.toString());
        continue;
      }
      for (int i = endOfKey+1; i < chars.length; i++) {
        if ((int)chars[i] >= 48 && (int)chars[i] <= 57)
        {
          int plainNumber = (int)chars[i];
          int cipherNumber = Math.abs(shiftAmount + plainNumber)%10 + 48;
          sb.append((char)cipherNumber);
        }
        if ((int)chars[i] >= 97 && (int)chars[i] <= 122)
        {
          int plainNumber = (int)chars[i];
          int cipherNumber = Math.abs(shiftAmount + plainNumber)%10 + 97;
          sb.append((char)cipherNumber);
        }
        else sb.append(chars[i]);
      }
      System.out.println(sb.toString());
    }
  }
  catch (IOException e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      if (buffReader != null)
      {
        buffReader.close();
      }
      if (fileReader != null)
      {
        fileReader.close();
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
}
