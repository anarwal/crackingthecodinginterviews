package com.chapter4;

/**
 * Created by abhimanyunarwal on 4/8/20.
 * Minimal Tree: Given a sorted array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */

public class MinimalTree {
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

    TreeNode createMinBST(int array[]){
        return createMinBST(array, 0,array.length-1);
    }
    TreeNode createMinBST(int[] array, int start, int end){
        int mid =(start+end)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left=createMinBST(array,start,mid-1);
        n.right=createMinBST(array, mid+1, end);
        return n;
    }
}
