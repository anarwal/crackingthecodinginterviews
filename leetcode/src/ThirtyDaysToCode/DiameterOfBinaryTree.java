package ThirtyDaysToCode;

import interviewQuestions.treeAndGraph.BinaryTreeInorderTraversal;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }


    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lH = height(root.left);
        int rH = height(root.right);
        maxDiameter = Math.max(lH + rH, maxDiameter);
        return Math.max(lH, rH) + 1;
    }
}
