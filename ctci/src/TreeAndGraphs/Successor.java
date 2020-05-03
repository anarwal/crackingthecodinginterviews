package TreeAndGraphs;

/**
 * Created by abhimanyunarwal on 4/11/20.
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent
 */

public class Successor {
    class TreeNode{

        int data;
        TreeNode node;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(TreeNode left, TreeNode right, TreeNode parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    TreeNode inOrderSucc(TreeNode node){
        if(node ==null){return null;}
        if(node.right !=null){
            return leftMost(node.right);
        }else{
            TreeNode q= node;
            TreeNode r= node.parent;
            while( r !=null && r.left !=q){
                q=r;
                r=r.parent;
            }
            return q;
        }
    }

    TreeNode leftMost(TreeNode n){
        if(n==null){
            return null;
        }
        while(n.left !=null){
            n = n.left;
        }
        return n;
    }
}
