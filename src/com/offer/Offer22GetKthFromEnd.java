package com.offer;

public class Offer22GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null || k==0) return null;
        ListNode cur = head;
        for (int i=0; i<k; i++){
            cur = cur.next;
            if(cur==null) return null;
        }
        while(cur!=null){
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}
