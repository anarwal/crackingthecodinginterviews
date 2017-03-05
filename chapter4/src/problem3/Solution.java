package problem3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (e.g. if you have a a tree with depth D, you will have D linked lists)
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

  /*
  Best approach here would be to use breadth first search, then at each level, all the nodes traversed
  can be put in linkedList and this would give linked list for every height, later store every linkedList
  in arrayList and return it
  */

  public static ArrayList<LinkedList<Node>> putInLinkedList(Node root){

    //create arrayList, which store linked list at every position
    ArrayList<LinkedList<Node>> finalList = new ArrayList<>();

    //create linkedList, which store nodes at a given height
    LinkedList<Node> list = new LinkedList<Node>();

    if(root==null){
      return null;
    }else if(root !=null){
        list.add(root);
    }

    //after adding root to list, traverse its children using bfs
    while(list.size()>0){
        finalList.add(list);

      //go-to children nodes for the current level and traverse all of them
      LinkedList<Node> parents = list;
      list=new LinkedList<Node>();

      for(Node parent : parents){

        if(parent.left !=null){
            list.add(parent.left);
        }
        if (parent.right !=null){
            list.add(parent.right);
        }
      }
      return finalList;
    }
    return null;
  }



}
