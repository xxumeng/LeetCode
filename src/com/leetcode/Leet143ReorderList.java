package com.leetcode;


// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leet143ReorderList {
//    快慢指针，快指针走两步，慢指针走一步
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
//    反转链表
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode pre = null, next=null;
        while(curr!=null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
//    合并链表
    public void mergeList(ListNode l, ListNode r){
        ListNode head = l;
        ListNode lNext=l, rNext=r;
        while(l!=null && r!=null){
            lNext = l.next;
            rNext = r.next;
            l.next = r;
            l = lNext;
            r.next = l;
            r = rNext;
        }
    }
    public void reorderList(ListNode head){
        if(head==null) return;
        ListNode middle = findMiddle(head);
        ListNode r = reverseList(middle.next);
        middle.next = null;
        mergeList(head, r);

    }
}
