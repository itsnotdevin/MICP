
package micp;

import org.junit.Test;
import static org.junit.Assert.*;

class treeNode{
    treeNode left, right;
    int data;
    treeNode(int val){
        data = val;
    }
}

public class week6Test {   
    public week6Test() {
    }

    @Test
    public void testHasSubtree() {
        
/*      s             t1        t2
        1             5          1   
        /\           / \        /
       5  2         4   6      5
      / \  \                    \
     4   6  3                    6
   
       t3            t4        t5        t6    
        1            1         5         2
        /\          / \       / \       /
       5  2        5   2     4   7     3
      / \  \      / \   \                
     4   6  3    4   6   3              
                          \
                           1   
*/   
        treeNode s = new treeNode(1);
        s.right = new treeNode(2);
        s.right.right = new treeNode(3);
        s.left = new treeNode(5);
        s.left.left = new treeNode(4);
        s.left.right = new treeNode(6);
        
        treeNode t1 = new treeNode(5);
        t1.left = new treeNode(4);
        t1.right = new treeNode(6);
        
        treeNode t2 = new treeNode(1);
        t2.left = new treeNode(5);
        t2.left.right = new treeNode(6);

        treeNode t3 = new treeNode(1);
        t3.right = new treeNode(2);
        t3.right.right = new treeNode(3);
        t3.left = new treeNode(5);
        t3.left.left = new treeNode(4);
        t3.left.right = new treeNode(6);        
        
        treeNode t4 = new treeNode(1);
        t4.right = new treeNode(2);
        t4.right.right = new treeNode(3);
        t4.right.right.right = new treeNode(1);
        t4.left = new treeNode(5);
        t4.left.left = new treeNode(4);
        t4.left.right = new treeNode(6);
        
        treeNode t5 = new treeNode(5);
        t5.left = new treeNode(4);
        t5.right = new treeNode(7);

        treeNode t6 = new treeNode(1);
        t2.left = new treeNode(5);
        t2.left.right = new treeNode(6);        
        
        // same structure, same data
        assertEquals(true, week6.hasSubtree(t1,s));
        // same structure, different data
        assertEquals(false, week6.hasSubtree(t5, s));      
        // different structure, same data
        assertEquals(false, week6.hasSubtree(t6, s));
        // different structure, different data
        assertEquals(false, week6.hasSubtree(t2, s));
        // height of S > T
        assertEquals(false, week6.hasSubtree(t4,s));
        // S == T
        assertEquals(true,week6.hasSubtree(t3, s));
        // S = null
        assertEquals(false, week6.hasSubtree(t1, null));
        // T = null
        assertEquals(true, week6.hasSubtree(null, s));
        
        // S & T = null
        boolean flag = false;
        try {
                week6.hasSubtree(null, null);
            }
        catch (IllegalArgumentException e){
                flag = true;
             }
        assertEquals(true, flag);
             
        // testing S and T are unaffected by running hasSubtree method.
        assertEquals(true,week6.hasSubtree(t1, s));
    }
    
}
