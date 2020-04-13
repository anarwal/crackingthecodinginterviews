package com.chapter4;


import java.util.Hashtable;

/**
 * Created by abhimanyunarwal on 4/13/20.
 * Path with sum: In a given binary tree where each node contains an integer value (could be +ve or -ve),
 * design an algorithm to count number of paths that sum to a given value.
 */

public class PathsWithSum {

    // we can use the concept of contiguous array sum, where we find value of maximum sum of consecutive terms in a given array.

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


    int countPathsWithSum(TreeNode root, int targetSum){
        return countPathsWithSum(root, targetSum, 0, new Hashtable<Integer, Integer>());
    }

    int countPathsWithSum(TreeNode node, int targetSum, int runningSum, Hashtable<Integer,Integer> pathCount){
        if(node == null) return 0;
        runningSum += node.data;
        int sum = runningSum-targetSum;
        int totalPath = pathCount.getOrDefault(sum, 0);

        if(runningSum == targetSum){
            totalPath++;
        }

        incrementHT(pathCount, runningSum, 1);
        totalPath += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPath += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHT(pathCount, runningSum, -1);

        return totalPath;
    }

    void incrementHT(Hashtable<Integer, Integer> htable, int key, int delta){
        if(delta==0){
            htable.remove(key);
        }else{
            htable.put(key, delta);
        }
    }
}
