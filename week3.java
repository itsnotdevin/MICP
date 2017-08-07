
import java.util.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class week3 {
    
    public static Integer[][] threePairs (Integer[] arr) throws IllegalArgumentException {
       HashSet<Integer> intSet = new HashSet<Integer>();
       HashSet<Integer[]> solSet = new HashSet<Integer[]>();
       ArrayList<Integer[]> list = new ArrayList<Integer[]>();
       Integer[] sol = new Integer[3];
       
       int target = 0;
       if (arr == null) throw new IllegalArgumentException();
       if (arr.length < 3) throw new IllegalArgumentException();
       for (int i = 0; i < arr.length; i++) {
           target= -1*(arr[i]);
           for (int j = 0; j<arr.length; j++) {
               if (j == i) continue;
               if(intSet.contains(arr[j])){
                   sol[0] = arr[i];
                   sol[1] = arr[j];
                   sol[2] = -1*(arr[i]+arr[j]);
                   if (solSet.add(sol))
                       list.add(sol);
               }
               intSet.add(arr[j]-target);
           }
        }
       
       Integer [][] retval = new Integer[solSet.size()][3];

        for (int i = 0; i < solSet.size(); i++){ 
            for (int j = 0; j < 3; j++){
                retval[i][j] = list.get(i)[j];
            }
        }
       return retval;
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkArgumentException() {
        Integer[] test = new Integer[2];
        
        System.out.println("* threePairsJUnit4Test: test method 1 - checkExpectedException()");
        week3.threePairs(null);
        week3.threePairs(test);
    }
}
