package linkedlists;

/**
 * Created by abhimanyunarwal on 3/20/20.
 * Delete Middle Node: Delete a node in middle of singly linked list, given only access to node.
 */

public class DeleteMiddleNode {
    static class Node
    {
        int data;
        Node next;

        public Node(int d)
        {
            data = d;
        }
    }

    boolean deleteNode(Node n){
        if(n == null || n.next == null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
