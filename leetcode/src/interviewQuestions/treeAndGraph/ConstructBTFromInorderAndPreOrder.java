package interviewQuestions.treeAndGraph;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/
public class ConstructBTFromInorderAndPreOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int preindex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length - 1;
        return buildTree(preorder, inorder, 0, len);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        int index = 0;
        TreeNode root = new TreeNode(preorder[preindex]);
        preindex++;
        if (start == end) return root;
        for (int j = start; j <= end; j++) {
            if (root.val == inorder[j]) {
                index = j;
            }
        }
        root.left = buildTree(preorder, inorder, start, index - 1);
        root.right = buildTree(preorder, inorder, index + 1, end);

        return root;
    }
}
