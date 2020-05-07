package bloomberg.linkedList;

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revl1 = reverse(l1);
        ListNode revl2 =reverse(l2);

        ListNode result = new ListNode(0);
        ListNode current = result;

        int carry =0;

        while( revl1!= null || revl2 !=null){
            int x = (revl1 != null) ? revl1.val : 0;
            int y = (revl2 != null) ? revl2.val : 0;

            int cur = x+y+carry;
            carry = cur/10;
            current.next = new ListNode(cur%10);
            current = current.next;
            if(revl1 !=null) revl1 = revl1.next;
            if(revl1 !=null) revl2 = revl2.next;
        }

        if(carry >0){
            current.next = new ListNode(carry);
        }
        return reverse(result.next);

    }


    ListNode reverse(ListNode node){
        ListNode prev = null;

        while(node !=null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
