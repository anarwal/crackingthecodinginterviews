package com.chapter2;

import java.util.HashSet;

/**
 * Created by abhimanyunarwal on 3/19/20.
 * Remove Duplicates: Write code to remove duplicates from an unsorted linked list
 */

public class RemoveDups {
    static class LinkedListNode
    {
        int val;
        LinkedListNode next;

        public LinkedListNode(int val)
        {
            this.val = val;
        }
    }

    void removeDups(LinkedListNode head){
        HashSet<Integer> hset = new HashSet<>();
        LinkedListNode current = head;
        LinkedListNode prev = null;
        while(current !=null){
            if(hset.contains(current.val)){
                prev.next = current.next;
            }else{
                hset.add(current.val);
            }
            current = current.next;
        }
    }
}
