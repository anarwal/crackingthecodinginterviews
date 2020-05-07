package bloomberg.linkedList;

public class ReversedLinkedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        // until starting point
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        //for final connectivity
        ListNode con = prev, tail = cur;

        //until reaching end
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

}
