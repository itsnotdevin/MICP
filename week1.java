
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class week1 {
public static void main(String[] args) throws Exception
{

  FileReader fileReader = null;
  BufferedReader buffReader = null;

  try {

    String tmp = null;
    int endOfNumber = 0;
    int shiftAmount = 0;
    fileReader = new FileReader("sample.csv");
    buffReader = new BufferedReader(fileReader);

    while ((tmp = buffReader.readLine()) != null) {
      char[] chars = tmp.toCharArray();

      // the least amount of characters for a valid input is 3
      // eg: "1:2"
      if (chars.length < 3)
        {
          System.err.println("Invalid input formatting: \"" + tmp + "\"");
          System.exit(-1);
        }

      for (int i = 0; i < chars.length; i++)
      {
        if (chars[i] == ":"))
        {
          endOfNumber = i;
          break;
        }
        if (chars[i].isLetter)
        {
          // shift amount is an integer.
          if (endOfNumber < 1 || )
          {
              System.err.println("invalid shift amount for string: \"" + tmp + "\"");
              System.exit(-1);
          }
        }
      }

      // there needs to be at least one character for the shift amount
      if (endOfNumber < 1 || )
      {
          System.err.println("invalid shift amount for string: \"" + tmp + "\"");
          System.exit(-1);
      }
      shiftAmount = Integer.parseInt(tmp.substring(0,endOfNumber));
      if (chars.length > endOfNumber + 1) {
        for (int i = endOfNumber + 1; i < chars.length; i++)
        {
          char a = shiftAmount
        }
      }
    }
  } catch (IOException e)
    {
      e.printStackTrace();
    } finally {
        try {
          if (buffReader != null)
          {
            buffReader.close();
          }
          if (fileReader != null)
          {
            fileReader.close();
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
    }
  }
}
