package interviewQuestions.treeAndGraph;

import java.util.ArrayList;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/791/
public class InorderSuccessorInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        ArrayList<TreeNode> alist = new ArrayList<>();
        inorder(root, alist);
        if(alist.indexOf(p)+1 == alist.size()){
            return null;
        }else{
            return  alist.get(alist.indexOf(p)+1) ;
        }
    }

    void inorder(TreeNode root, ArrayList<TreeNode> list){
        if(root!=null){
            if(root.left!=null){
                inorder(root.left, list);
            }
            list.add(root);
            if(root.right!=null){
                inorder(root.right, list);
            }
        }
    }
}
