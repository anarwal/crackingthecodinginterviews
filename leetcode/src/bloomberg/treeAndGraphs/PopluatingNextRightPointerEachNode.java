package bloomberg.treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/
public class PopluatingNextRightPointerEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<Node>();

        //adding root to head of the queue
        q.add(root);

        while(q.size()>0){

            int size = q.size();

            for(int i=0; i<size; i++){

                Node node = q.poll();

                if(i<size-1){
                    node.next = q.peek();
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return root;

    }
}
