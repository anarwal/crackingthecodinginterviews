package interviewQuestions.linkedlists;

import java.util.HashSet;

// Problem:https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
public class IntersectionOfTwoLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            HashSet<ListNode> hset = new HashSet<>();
            while (headA != null) {
                hset.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (hset.contains(headB)) return headB;
                else {
                    headB = headB.next;
                }
            }
            return null;
        }
    }
}
