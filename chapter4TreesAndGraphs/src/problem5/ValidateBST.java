package problem5;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * Validate BST: Implement a function to check if a binary tree is binary search tree
 */
public class ValidateBST {

  class Node{
    int data;
    Node left, right;
    public Node(int data){
      this.data= data;
      left=right=null;
    }
  }


public static boolean checkBST(Node root){
  return isBst(root, null, null);

}
  public static boolean isBst(Node node, Integer min, Integer max){
    //check for null case
    if(node==null){return true;}

    /*
    Here the logic is we compare every node in left subtree and right subtree to minimum and maximum value ,
    these could be the constraints given or you can choose as null or INTEGER.MIN_VALUE, INTEGER.MAX_VALUE.
    We will update values minimum and maximum as we move down the tree
    */

    if((min !=null && node.data<min) || (max !=null && node.data>max)){return false;}
    if(!(isBst(node.left, min, node.data-1)) || !(isBst(node.right, node.data+1, max))){return false;}
    return true;

  }
}
