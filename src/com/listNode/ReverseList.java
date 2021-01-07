package com.listNode;

import java.util.List;
class ListNode {
    ListNode(int val){
        this.val = val;
    }
    int val = 0;
    ListNode next = null;
}

public class ReverseList {
    ListNode successor = null; // 后驱节点
    public ListNode reverse(ListNode head, int n){
        if (n==1) {
            successor = head.next;
            return head;
        }
//        if (head.next==null) return head;
        ListNode last = reverse(head.next, n-1);
        head.next.next = head;
        head.next = null;
//        head.next = successor;
        return last;
    }
    public ListNode patialReverse(ListNode head, int m, int n){
//        System.out.println(head.val);
        if (m==1) return reverse(head, n);
        head.next = patialReverse(head.next, m-1, n-1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        ReverseList solve = new ReverseList();
//        head = solve.reverse(head, 2);
        head = solve.patialReverse(head, 2, 3);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
