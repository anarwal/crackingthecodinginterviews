package com.chapter2;

import java.util.LinkedList;

/**
 * Created by abhimanyunarwal on 3/20/20.
 * Partition: Partition the linked list around a value x, such that element smaller than x comes before all nodes greater or smaller then x.
 */

public class Partition {
    static class LinkedListNode
    {
        int data;
        LinkedListNode next;

        public LinkedListNode(int d)
        {
            data = d;
        }
    }

    LinkedListNode partition(LinkedListNode node, int n){
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node !=null){
            LinkedListNode next = node.next;
            if(node.data<n){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next=null;
        return head;
    }
}
