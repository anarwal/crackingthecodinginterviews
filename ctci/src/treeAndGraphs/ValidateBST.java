package treeAndGraphs;

/**
 * Created by abhimanyunarwal on 4/11/20.
 * Validate BST: Implement a function to check if a binary tree is binary search tree
 */

public class ValidateBST {
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

    boolean verify(TreeNode root){
        return checkBST(root, null, null);
    }
    boolean checkBST(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min !=null && root.data<min || max!=null && root.data>max){
            return false;
        }

        if(!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)){
            return false;
        }
        return true;
    }
}
