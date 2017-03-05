package problem4;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one.
 */
public class Solution {

    class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    /*
    here we just need to check heights of both left and right and compare them, so we traverse all the way
    to the last leaf node in both left subtree and right subtree, then as we go up we keep on increasing
    height for the subtree.
    */

  public boolean verifyBalanced(Node root){
    int result = isBalanced(root);
    if(result>0){return true;}
    else{return false;}
  }

  public int isBalanced(Node root){
    if(root == null){
      return Integer.MIN_VALUE;
    }

    int lHeight = isBalanced(root.left);
    if(lHeight == Integer.MIN_VALUE){
      return Integer.MIN_VALUE;
    }

    int rHeight = isBalanced(root.right);
    if(rHeight ==  Integer.MIN_VALUE){
      return Integer.MIN_VALUE;
    }
    if(Math.abs(lHeight - rHeight)>1){
      return Integer.MIN_VALUE;
    }else{
      return 1+Math.max(lHeight,rHeight);
    }

  }

//  public boolean isBalanced(Node root){
//    int lHeight=0;
//    int rHeight=0;
//    if(root == null){
//      return false;
//    }
//
//    /*
//    here we just need to check heights of both left and right and compare them, so we cn use dfs and
//    traverse to the last leaf node in both left subtree and right subtree, later compare their heights.
//    */
//    Node temp= root;
//    while(temp.left != null){
//      lHeight++;
//    }
//    while(temp.right !=null){
//      rHeight++;
//    }
//    if(Math.abs(lHeight-rHeight)==1){
//      return true;
//    }else{
//      return false;
//    }
//  }
}
