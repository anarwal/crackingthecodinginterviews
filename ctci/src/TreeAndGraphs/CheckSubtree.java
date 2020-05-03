package TreeAndGraphs;

/**
 * Created by abhimanyunarwal on 4/13/20.
 * Check Subtree: T1 and T2 are binary tress with T1 much larger then T2. Create algorithm to determine if T2 is a subtree of T1.
 */

public class CheckSubtree {
    class TreeNode{

        int data;
        TreeNode node;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    boolean check(TreeNode T1, TreeNode T2){
        if(T2 == null) return true;
        return isSubtree(T1, T2);
    }

    boolean isSubtree( TreeNode T1, TreeNode T2 ){
        if(T1 == null) return false;
        else if(T1.data == T2.data && matchSubTree(T1, T2)) return true;
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    boolean matchSubTree(TreeNode T1, TreeNode T2){
        if( T1==null && T2 == null) return true;
        else if (T1 == null || T2 ==null) return false;
        else if(T1.data != T2.data) return false;
        else return matchSubTree(T1.left, T2.left) && matchSubTree(T1.right, T2.right);
    }
}
