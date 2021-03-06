package thirtyDaysToCode;

public class MiddleOfLinkedList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow_ptr = head;
            ListNode fast_ptr = head;
            if (head != null)
            {
                while (fast_ptr != null && fast_ptr.next != null)
                {
                    fast_ptr = fast_ptr.next.next;
                    slow_ptr = slow_ptr.next;
                }
            }
            return slow_ptr;
        }
    }
}
