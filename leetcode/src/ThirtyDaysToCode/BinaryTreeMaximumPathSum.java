package ThirtyDaysToCode;

public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return maxSum;
    }

    public int findMaxSum(TreeNode root) {
        if (root == null) return 0;
        int lsum = Math.max(0, findMaxSum(root.left));
        int rSum = Math.max(0, findMaxSum(root.right));
        maxSum = Math.max(maxSum, lsum + rSum + root.val);
        return Math.max(lsum, rSum) + root.val;
    }
}
