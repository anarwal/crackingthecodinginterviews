package bloomberg.treeAndGraphs;

import java.util.*;

public class BinaryTreeRightView {
    class TreeNode {

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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> alist = new ArrayList<>();
        if (root == null) return alist;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (i == size - 1) {
                    alist.add(node.data);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }
        return alist;
    }
}
