package com.offer;

public class Offer18DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head!=null && head.val==val) return head.next;
        ListNode pre = null, cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
