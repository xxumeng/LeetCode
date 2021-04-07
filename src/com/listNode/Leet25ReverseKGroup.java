package com.listNode;

public class Leet25ReverseKGroup {
//    反转[a,b)区间，返回新的头
    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre=null, behind= null;
        while(a!=b){
            behind = a.next;
            a.next= pre;
            pre = a;
            a = behind;
        }
        return pre;
    }


//    k个一组递归调用反转[a,b)区间，使得前一个的尾部指向后一个的头部
    public ListNode reverseKGroup(ListNode head, int k){
        if (head==null) return null;
        if (k<=1) return head;
        ListNode b = head;
        for(int i=0; i<k; i++){
            if (b==null) return head;
            b = b.next;
        }
        ListNode rHead = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return rHead;
    }
}
