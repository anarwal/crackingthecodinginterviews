package com.chapter4;

/**
 * Created by abhimanyunarwal on 4/9/20.
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one.
 */

public class CheckBalanced {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public TreeNode[] children;
    }

    public boolean checkBalanced(TreeNode head){
        return checkHeight(head) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeNode root){
        if(root ==null){return -1;}
        int lHeight = checkHeight(root.left);
        if(lHeight==Integer.MIN_VALUE){return Integer.MIN_VALUE;}

        int rHeight = checkHeight(root.right);
        if(rHeight==Integer.MIN_VALUE){return Integer.MIN_VALUE;}

        int diffHeight = lHeight - rHeight;
        if(Math.abs(diffHeight) >1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(lHeight, rHeight)+1;
        }
    }
}
