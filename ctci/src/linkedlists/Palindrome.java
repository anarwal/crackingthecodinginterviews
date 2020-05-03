package linkedlists;

/**
 * Created by abhimanyunarwal on 3/20/20.
 * Palindrome: Write a function to check if linked list is a palindrome
 */

public class Palindrome {
    static class Node
    {
        int data;
        Node next;

        public Node(int d)
        {
            data = d;
        }
    }

    Node SplitList(Node head){
        Node slow = head;
        Node fast = head.next.next;

        while(fast != null){
            fast =  fast.next;
            if( fast != null){
                slow=slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    boolean isPalindrome(Node head){
       Node a = head, b, list1Tail, list2Head;

       list1Tail = SplitList(head);

       b = list1Tail.next;
       list1Tail.next = null;

       b= reverse(b);
       list2Head = b;
       return isEqual(head, list2Head);
    }

    Node reverse(Node head){
        Node prev =null;
        Node current=head;
        Node next = null;
        while(current !=null){
            next = current.next;
            current.next = prev;
            prev=current;
            current=next;
        }
        head = prev;
        return head;

    }

    boolean isEqual(Node one, Node two){
        Node head1 = one;
        Node head2 = two;
        while(head1 !=null && head2 != null){
            if(head1.data!=head2.data){
                return false;
            }
            head1 =head1.next;
            head2 =head2.next;
        }
        if(head1 == null && head2==null){
            return true;
        }
        return false;
    }
}
