package bloomberg.treeAndGraphs;

public class FlattenBinaryTreeToLinkedList {
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

    public void flatten(TreeNode root) {
        callFlatten(root);
    }

    TreeNode callFlatten(TreeNode root){

        if(root == null ){ return null;}
        if(root.left == null&& root.right ==null){return root;}

        TreeNode left = callFlatten(root.left);
        TreeNode right= callFlatten(root.right);

        if(left !=null){
            left.right = root.right;
            root.right = root.left;
            root.left=null;
        }

        return right==null?left : right;
    }
}
