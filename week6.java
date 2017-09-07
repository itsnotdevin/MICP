package solution;

class treeNode{
    treeNode left, right;
    int data;
    treeNode(int val){
        data = val;
    }
}
public class week6 {
    public static boolean hasSubtree(treeNode T, treeNode S){
        if (T == null && S == null) throw new IllegalArgumentException("hasSubtree(treeNode T, treeNode S) T and S cannot both be null.");
        if (T == null) return true;
        if (S == null) return false;
        if (T.data == S.data){
            if (isEqual(T,S)){
                return true;
            }
        }
        return (hasSubtree(T, S.left) || hasSubtree(T,S.right));
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
