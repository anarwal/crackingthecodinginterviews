package bloombergTop;

import java.util.Stack;

public class FlattenMultiLevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Stack<Node> parents = new Stack<>();
    public Node flatten(Node head) {
        if (head == null) return head;
        listFlatten(head);
        return head;
    }

    public Node listFlatten(Node head){
        Node prev = null;
        Node cur = head;

        while(cur !=null){
            if(cur.child != null){
                Node newNode = listFlatten(cur.child);
                newNode.next = cur.next;

                if(cur.next != null){
                    cur.next.prev = newNode;
                }

                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;

                cur = newNode;
            }

            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}
