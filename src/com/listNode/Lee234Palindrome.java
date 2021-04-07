package com.listNode;

public class Lee234Palindrome {
    public ListNode reverse(ListNode head){
        ListNode pre = null, nxt = null;
        while(head!=null){
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode low = head, fast = head;
        while(fast!=null && fast.next!=null){
            low = low.next;
            fast = fast.next.next;
        }
        ListNode rList = reverse(low);
        while(head!=null && rList!=null){
            if (head.val!=rList.val) return false;
        }
        return true;
    }
}
