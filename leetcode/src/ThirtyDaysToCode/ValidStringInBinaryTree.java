package ThirtyDaysToCode;

public class ValidStringInBinaryTree {
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

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null && arr.length ==0) return true;
        return dfs(root, arr, 0, arr.length);
    }

    boolean dfs(TreeNode node, int[] array, int i, int j) {
        if(array[i] != node.val) return false;

        if (i == j - 1 ) return node.left == null && node.right == null;

        if(node.left !=null && dfs(node.left, array, i+1, j)){
            return true;
        }

        if(node.right !=null &&  dfs(node.right, array, i+1, j)){
            return true;
        }

        return false;
    }
}
