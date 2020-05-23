package general;

import java.util.ArrayList;
import java.util.List;

public class LeavesOfBinaryTree {
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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList<>();
        while(root !=null){
            List<Integer> levelList = new ArrayList<>();
            root = backtrack(root, levelList);
            finalResult.add(levelList);
        }

        return finalResult;
    }

    TreeNode backtrack(TreeNode root, List<Integer> levelList){
        if(root == null) return null;

        if(root.left == null && root.right == null){
            levelList.add(root.data);
            return null;
        }

        root.left = backtrack(root.left, levelList);
        root.right = backtrack(root.right, levelList);
        return root;
    }

}

