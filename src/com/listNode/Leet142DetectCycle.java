package com.listNode;
/*
* 判断是否有环，返回环的第一个节点
* */
public class Leet142DetectCycle {
    public ListNode hasCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode low = head,fast = head;
        low = head.next;
        fast = low.next;
        while (low!=fast){
            if (fast==null || fast.next==null) return null;
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode meet = hasCycle(head);
        if (meet==null) return null;
        ListNode low = meet, fast = head;
        while (low!=fast){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
