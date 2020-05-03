package interviewQuestions.treeAndGraph;

import java.util.HashMap;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
public class KthSmallestElementInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int i = 1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        inorder(root, hmap);
        return hmap.get(k);
    }

    void inorder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, map);
            }
            map.put(i, root.val);
            i++;
            if (root.right != null) {
                inorder(root.right, map);
            }
        }

    }
}
