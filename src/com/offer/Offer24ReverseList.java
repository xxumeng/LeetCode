package com.offer;

public class Offer24ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode p = head;
        while(p!=null){
            ListNode temp = p.next;
            p.next = cur;
            cur = p;
            p = temp;
        }
        return cur;
    }
}
