package com.listNode;

import java.util.List;

public class Leet141HasCircle {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode low = head,fast = head;
        low = head.next;
        fast = low.next;
        while (low!=fast){
            if (fast==null || fast.next==null) return false;
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }
}
