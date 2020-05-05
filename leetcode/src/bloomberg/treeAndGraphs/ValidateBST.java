package bloomberg.treeAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
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

    List<Integer> alist = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root, alist);
        for(int i=0; i<alist.size()-1; i++){
            if(alist.get(i)>=alist.get(i+1)){
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left != null) inorder(root.left, list);
            list.add(root.data);
            if(root.right != null) inorder(root.right, list);
        }
    }
}
