package problem2;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * Minimal Tree: Given a sorted(increasing order) array with unique integer elements, write and algorithm
 * to create a binary search tree with minimal heights
 */

public class Solution {

  class Node{
    Node left, right;
    int data;
    public Node(int data){
        this.data=data;
        left=right=null;

    }

  }

  public Node createBST(int[] array){
    return minimalBST(array, 0, array.length-1);
  }


/*
in order for binary tree have minimal height it must be a complete binary tree, it would help binary
search tree to maintain minimal height.
Now as array is sorted it is easy for us to choose so we can divide in smaller and greater terms then
choose the middle element of array to be the root, the element on the left will be smaller and element to
the right will be greater then root, now using recursion and choosing middle, put all the elements in graph
*/

  public Node minimalBST(int[] array, int start, int end){
    if(end<start){
      return null;
    }
    int middle=(start+end)/2;
    Node n = new Node(array[middle]);
    n.left=minimalBST(array, start, middle-1);
    n.right=minimalBST(array, middle+1, end);
    return n;
  }
}
