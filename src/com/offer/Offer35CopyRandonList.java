package com.offer;

import java.util.HashMap;

/*
* 根据next指针进行复制，但无法构建random的指向
* 本题难点：原链表与新链表节点的对应关系
* 递归太费时
* */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Offer35CopyRandonList {
    HashMap<Node, Node> map = new HashMap<>();
//    public Node copyNext(Node origin){
//        if(origin==null) return null;
//        Node copy = new Node(origin.val);
//        map.put(origin, copy);
//        copy.next = copyNext(origin.next);
//        copy.random = map.get(origin.random);
//        return copy;
//    }
//    public Node copyRandomListDfs(Node head) {
//        if (head==null) return null;
//        Node copy_head = copyNext(head);
//        return copy_head;
//    }

    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    public static void main(String[] args) {

    }
}
