package problem6;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent
 */
public class InOrderSuccessor {

  class Node{
    int data;
    Node left,right;
    Node parent;
    public Node(int data){
      this.data=data;
      left=right=null;
      parent= null;
    }
  }

  public void inOrder(Node root){
    if(root==null){return;}
    if(root !=null){
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  public Node minVal(Node node){
    Node current = node;
    while(current.left !=null){
      current=current.left;
    }
    return current;
  }

  /*
  * here the logic would be considering if you do not have parent pointer, you will traverse with following two conditions:
  * 1. If the node has right subtree then the smallest value (leftmost) in right subtree will be the value
  * 2. If the right subtree of node is NULL, then we will start from root and traverse down finding the right value of given
  * node. Where if node is greater then root data go right otherwise go left to target node
  */
  public Node getNext(Node root, Node node){
    if (node==null){return null;}

    if(node.right !=null){
      return minVal(node.right);
    }

    Node temp=null;
    while(root !=null){
      if(node.data<root.data){
        temp = root;
        root=root.left;
      }
      else if(node.data>root.data){
        root=root.right;
      }else {
        break;
      }
    }
    return temp;
  }

  /*
  * Approach 2:
  * Now as the question says we know the pointer to parent, we can leverage that and build our algorithm too, with following:
  * 1. If the node has right subtree then the smallest value (leftmost) in right subtree will be the value (this is similar)
  * 2. If the right subtree is NULL, then traverse up the tree till node exists to the right of parent
  * */

  public Node getNextNode(Node node){
    if (node==null){return null;}

    if(node.right !=null){
      return minVal(node.right);
    }

    Node par = node.parent;
    while(par !=null && node==par.right){
      node = par;
      par = par.parent;
    }
    return par;
  }


}
