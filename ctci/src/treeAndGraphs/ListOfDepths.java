package treeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by abhimanyunarwal on 4/8/20.
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (e.g. if you have a a tree with depth D, you will have D linked lists)
 */

public class ListOfDepths {

    class Node{
        Node left, right;
        int data;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    ArrayList<LinkedList<Node>> listOfDepths(Node root){
        ArrayList<LinkedList<Node>> aList = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();
        if(root == null){
            return null;
        }
        linkedList.add(root);
        while(linkedList.size()>0){
            aList.add(linkedList);

            LinkedList<Node> parents = linkedList;
            linkedList =new LinkedList<Node>();

            for(Node parent: parents){
                if(parent.left!=null){
                    linkedList.add(parent.left);
                }
                if(parent.right!=null){
                    linkedList.add(parent.right);
                }
            }
            return aList;
        }
        return null;
    }

}
