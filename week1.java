import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class week1
{
  public static String week1(String tmp) throws Exception
  {
        if (tmp == null)
        {
          throw new IOException("null input");
        }
        char[] chars = tmp.toCharArray();
        int[] values = getKey(tmp, chars);
        String retval = shiftString(tmp, chars, values);
        return (retval);
  }
private static int[] getKey (String tmp, char[] chars) throws Exception
{
  chars = tmp.toCharArray();
  int endOfKey = -1;
  for (int i = 0; i < chars.length; i++)
  {
    // Edge Case: no letters allowed in the key.
    if (Character.isLetter(chars[i]))
    {
      throw new IllegalArgumentException("letter in key");
    }
    // Edge Case: No spaces allowed in the key.
    if (chars[i] == ' ') {
      throw new IllegalArgumentException("space in key");
    }
    // Edge Case: if a character in a key does not represent a digit,
    // and the character is not a semicolon or a minus symbol at the beginning of the key.
    if (!Character.isDigit(chars[i]))
    {
      if ((chars[i] == '-' && i != 0) && chars[i] != ':')
      {// Edge Case: no symbols allowed in the key..
        throw new IllegalArgumentException("symbol in key");
      }
    }
    if (chars[i] == ':')
    {
      // Edge Case: look ahead to make sure -: is not allowed through.
      if (tmp.substring(0,i) == "-")
      {
      throw new IllegalArgumentException("invalid key");
      }
      endOfKey = i;
      break;
    }
  }

  if (endOfKey < 1)
  {
    // Edge case: no : found, or misformatted key.
      throw new IllegalArgumentException("missing key");
  }

  int[] keyVals = new int[2];
  keyVals[0] = endOfKey;
  keyVals[1] = Integer.parseInt(tmp.substring(0,endOfKey));

  return keyVals;
}

private static String shiftString (String tmp, char[] chars, int[] keyVals) throws Exception {
  StringBuilder sb = new StringBuilder();
	chars = tmp.toCharArray();
  // if shift is 0, no need to apply.
  if (keyVals[1] == 0)
  {
    return(chars.toString());
  }
  for (int i = keyVals[0]+1; i < chars.length; i++) {
    int a = chars[i];
    int cipherNumber;

    if (a >= 48 && a <= 57)
    {
      cipherNumber = (a + keyVals[1]%10);
      if (cipherNumber < 48)
      {
        cipherNumber += 10;
        sb.append((char)cipherNumber);
        continue;
      }
      else
      {
        sb.append((char)cipherNumber);
        continue;
      }
    }
    if (a >= 65 && a <= 90)
    {
      cipherNumber = (a + keyVals[1]%26);
      if (cipherNumber < 65)
      {
        cipherNumber += 26;
        sb.append((char)cipherNumber);
        continue;
      }
      else
      {
        sb.append((char)cipherNumber);
        continue;
      }
    }
    if (a >= 97 && a <= 122)
    {
      cipherNumber = (a + keyVals[1]%26);
      if (cipherNumber < 97)
      {
        cipherNumber += 26;
        sb.append((char)cipherNumber);
        continue;
      }
      else
      {
        sb.append((char)cipherNumber);
        continue;
      }
    }
    else sb.append((char)a);
  }
  return sb.toString();
  }
}
