package TreeAndGraphs;

/**
 * Created by abhimanyunarwal on 4/14/20.
 * First Common Ancestor: Find first common ancestor of two given nodes in a binary tree
 */

public class FirstCommonAncestor {
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node LCA( Node root, Node n1, Node n2){
        if(root == null) return null;

        if( root == n1 || root == n2) return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left !=null && right !=null) return root;
        if(left == null && right == null) return null;

        return left !=null ? left:right;
    }
}
