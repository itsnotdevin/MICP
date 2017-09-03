package micp;

/* space complexity: hasSubtree() O(tmp1 + tmp2) where tmp1 and tmp2 are copies of S and T
                     findSubtree() O(hS) where hS is height of subtree S
                     isEqual() O(hT) where hT is height of subtree T
              total: isEqual(min(hS,hT)+tmp1+tmp2)
                     since our recursive calls terminate once of the two trees have reached null, we will only ever
                     have the smallest tree on our call stack at one time.

   time complexity: hasSubtree() O(1) constant amount of work.
                    findSubtree() O(2^hS) where hS is the height of subtree S.
                    isEqual() O(2^hT) where hT is the height of subtree T.
               total: (O(2^hS)* min(2^hS, 2^hT) + O(1))
                    findSubtree runs for the entire height of tree S.
                    isEqual only runs until the smaller of the two trees reach null, potentially every iteration of findSubtree.
*/

class treeNode{
    treeNode left, right;
    int data;
    treeNode(int val){
        data = val;
    }
}
public class week6 {
    public static boolean hasSubtree(treeNode T, treeNode S) throws IllegalArgumentException {
        if (T == null && S == null) 
            throw new IllegalArgumentException("hasSubtree(T, S): T and S cannot both be null.");
        treeNode tmp1 = T; 
        treeNode tmp2 = S;
        return findSubtree(tmp1, tmp2);
    }
    private static boolean findSubtree(treeNode T, treeNode S){        
        if (T == null) return true;
        if (S == null) return false;
        if (T.data == S.data){
            if (isEqual(T,S)){
                return true;
            }
        }
        return (findSubtree(T, S.left) || findSubtree(T,S.right));
    }
    private static boolean isEqual(treeNode T, treeNode S) {
        if (T == null && S == null) return true;
        if (T == null || S == null) return false;
        if (T.data == S.data){
            return (isEqual(T.left, S.left) && isEqual(T.right, S.right));
        }
        return false;
    }
}
