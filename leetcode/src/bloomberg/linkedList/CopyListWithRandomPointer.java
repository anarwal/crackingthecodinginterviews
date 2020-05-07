package bloomberg.linkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Iterative
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hmap = new HashMap<>();
        for(Node temp = head; temp !=null; temp =temp.next){
            hmap.put(temp, new Node(temp.val, null, null));
        }
        for(Node temp = head; temp !=null; temp =temp.next){
            hmap.get(temp).random = hmap.get(temp.random);
            hmap.get(temp).next = hmap.get(temp.next);
        }
        return hmap.get(head);
    }


    //Recursive
    HashMap<Node, Node> clone = new HashMap<>();
    public Node copyRandomListRecursive(Node head){
        copyList(head);
        return head;
    }

    Node copyList(Node head){
        if(head == null) return head;
        if(clone.containsKey(head)){
            return clone.get(head);
        }
        Node temp = new Node(head.val, head.next, head.random);
        clone.put(head, temp);
        temp.next = copyList(head.next);
        temp.random = copyList(head.random);
        return temp;
    }
}
