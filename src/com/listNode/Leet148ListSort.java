package com.listNode;

public class Leet148ListSort {
    //合并
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode mergeHead = new ListNode(0);
        ListNode temp = mergeHead;
        while (h1!=null || h2!=null){
            if (h1==null) {
                temp.next=h2;
                break;
            }
            if (h2==null) {
                temp.next=h1;
                break;
            }
            if (h1.val<= h2.val){
                temp.next = h1;
                h1 = h1.next;
            }
            else {
                temp.next=h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        return mergeHead.next;
    }
    public ListNode sortList(ListNode head){
        if (head==null || head.next==null) return head;
        //获取链表长度
        ListNode temp = head;
        int listLen = 0;
        while (temp!=null){
            listLen ++;
            temp = temp.next;
        }
        //创建一个空节点作为头部
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (int sub = 1; sub < listLen; sub<<=1) {
            //一轮归并，temp是当前指针，pre是每小组归并前一个节点
            temp = dummyHead.next;
            ListNode pre = dummyHead;
            while (temp!=null){
                //截取h1
                ListNode h1=temp,h2;
                for (int i = 1; i < sub && temp.next!=null; i++) {
                    temp = temp.next;
                }
                //注意使h1尾部指向空
                h2 = temp.next;
                temp.next = null;

                //截取h1
                temp = h2;
                for (int i = 1; i < sub && temp!=null; i++) {
                    temp = temp.next;
                }

                //注意使h2尾部指向空，记录next节点；
                ListNode next = null;
                if (temp!=null){
                    next = temp.next;
                    temp.next = null;
                }

                //合并
                ListNode mergeHead = merge(h1,h2);
                pre.next = mergeHead;

                //使pre指针为当前合并组的尾部
                while (pre.next != null) {
                    pre = pre.next;
                }
                temp = next;
            }
        }
        return dummyHead.next;
    }
}
