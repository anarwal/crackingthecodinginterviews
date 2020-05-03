package TreeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by abhimanyunarwal on 3/5/17.
 * Random Node: You are implementing a binary tree class from scratch which ,in addition to insert, find and delete,
 * has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode, and explain how you would implement rest of the methods.
 */

public class ImplementBST {
    static class Node {
        int data;
        Node left, right;
        int size = 0;

        public Node(int data) {
            this.data = data;
            left = right = null;
            size = 1;
        }


        Node root = null;


        public void insert(int val) {

            /*
             * In order to insert to a binary tree, we have to maintain the rule for binary tree i.e. every node has atmost 2
             * children nodes, so we start inserting from root node and then start inserting in BFS fashion
             * */
            if (root == null) {
                root = new Node(val);
                return;
            }

            Queue<Node> toBeProcessed = new LinkedList<Node>();
            toBeProcessed.add(root);

            while (!(toBeProcessed.isEmpty())) {
                Node temp = toBeProcessed.poll();

                //If no left child
                if (temp.left == null) {
                    temp.left = new Node(val);
                    return;
                } else if (temp.right == null) {
                    temp.right = new Node(val);
                    return;
                }

                toBeProcessed.add(temp.left);
                toBeProcessed.add(temp.right);
            }
            size++;
        }


        public int size() {
            return size;
        }

        public int data() {
            return data;
        }

        public boolean find(Node root, int val) {
            if (root == null) {
                return false;
            }
            if (root != null) {
                if (root.data == val) {
                    return true;
                } else {
                    return (find(root.left, val) || find(root.right, val));
                }
            }
            return false;
        }

        public void delete(int data) {

            root = deleteNode(root, data);

        }

        public Node deleteNode(Node root, int data) {
            if (root == null) {
                return root;
            }
            if (root.data > data) {
                root.left = deleteNode(root.left, data);
            } else if (root.data < data) {
                root.right = deleteNode(root.right, data);
            } else {
                if (root.left == null && root.right == null) {
                    return root;
                }
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }


                root.data = minVal(root.right);

                root.right = deleteNode(root.right, root.data);
            }
            return root;
        }

        public int minVal(Node root) {
            int v = root.data;
            while (root.left != null) {
                v = root.left.data;
                root = root.left;
            }
            return v;
        }

        public Node getRandomNode() {
            int leftSize = (left == null) ? 0 : left.size();
            Random r = new Random();
            int index = r.nextInt(leftSize);
            if (index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }


    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.insert(10);
        root.insert(15);
        root.insert(5);
        root.insert(6);
        root.find(root, 15);
        root.delete(10);
        root.getRandomNode();
    }
}
