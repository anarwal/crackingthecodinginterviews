package interviewQuestions.treeAndGraph;
//Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevel {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> aList = new ArrayList<>();

        if (root == null) {
            return aList;
        }

        LinkedList<TreeNode> q1 = new LinkedList<>(); //left to right
        LinkedList<TreeNode> q2 = new LinkedList<>(); //right to left

        q1.addFirst(root);
        boolean traversal_left = false;
        while (!q1.isEmpty() || !q2.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.pollFirst();
                levelList.add(node.val);
                if (node.right != null) {
                    q2.addFirst(node.right);
                }
                if (node.left != null) {
                    q2.addFirst(node.left);
                }

            }
            if (!levelList.isEmpty()) {
                aList.add(new ArrayList<>(levelList));
            }

            while (!q2.isEmpty()) {
                TreeNode node = q2.pollLast();
                levelList.add(node.val);
                if (node.left != null) {
                    q1.addFirst(node.left);
                }
                if (node.right != null) {
                    q1.addFirst(node.right);
                }
            }
            if (!levelList.isEmpty()) {
                aList.add(new ArrayList<>(levelList));
            }

            aList.add(levelList);

        }
        return aList;

    }
}
