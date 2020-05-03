package interviewQuestions.treeAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int index = 0;

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> aList = new ArrayList<>();
        inorder(root, aList);
        return aList;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorder(root.right, list);
            }
        }
    }
}
