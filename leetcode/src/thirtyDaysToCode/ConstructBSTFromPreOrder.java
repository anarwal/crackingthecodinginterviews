package thirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
public class ConstructBSTFromPreOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1; i<preorder.length; i++){
            preordertraversal(preorder[i], root);
        }
        return root;
    }

    public TreeNode preordertraversal(int val, TreeNode node){
        if(node == null){
            return new TreeNode(val);
        }

        if(val<node.val){
            TreeNode left = preordertraversal(val, node.left);

            node.left=left;
            return node;
        }else{
            TreeNode right = preordertraversal(val, node.right);
            node.right=right;
            return node;
        }
    }
}
