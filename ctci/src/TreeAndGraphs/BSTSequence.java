package TreeAndGraphs;

import java.util.LinkedList;

/**
 * Created by abhimanyunarwal on 4/13/20.
 * BST Sequence: Given a binary search tree with distinct elements print all the possible arrays that could have led to this tree.
 */

public class BSTSequence {

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

    public LinkedList<LinkedList<TreeNode>> allSeqs;

    public void bstSequences(TreeNode root) {
            // create a list of all possible sequences
            allSeqs = new LinkedList<>();

            //nodes which have been already visited
            LinkedList<TreeNode> visited = new LinkedList<>();

            //nodes which are yet to be visited
            LinkedList<TreeNode> choices = new LinkedList<>();

            buildSeqs(visited, choices, root);
            for (LinkedList<TreeNode> lList : allSeqs) {
                for (TreeNode n : lList) {
                    System.out.print(n.data + " ");
                }
            }
    }

    private void buildSeqs(LinkedList<TreeNode> visited, LinkedList<TreeNode> choices, TreeNode root) {
        visited.add(root);
        if (root.left != null) {
            choices.add(root.left);
        }
        if (root.right != null) {
            choices.add(root.right);
        }

        if (choices.isEmpty()) {
            allSeqs.add(visited);
        }

        for (TreeNode n: choices) {
            LinkedList<TreeNode> temp = (LinkedList<TreeNode>) visited.clone();
            LinkedList<TreeNode> ptemp = (LinkedList<TreeNode>) choices.clone();
            ptemp.remove(n);
            buildSeqs(temp, ptemp, n);
        }
    }

}
