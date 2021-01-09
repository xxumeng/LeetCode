package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class TreeToDoublyList {
    Node listHead = new Node(0, null, null);
    Node pre = listHead;
    Queue<Node> queue = new ArrayDeque<>();
    public void traverse(Node root){
        if (root==null) return;
        traverse(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        traverse(root.right);
    }
    public Node treeToDoublyList(Node root) {
        traverse(root);

//        while(queue!=null){
//            Node p = queue.poll();
//            if(p==null) break;
////            System.out.println(p.val);
//            pre.right = p;
//            p.left = pre;
//            pre = p;
//        }
        pre.right = listHead.right;
        listHead.right.left = pre;
//        return listHead.right;
        return listHead;
    }

    public static void main(String[] args) {
        TreeToDoublyList solve = new TreeToDoublyList();
        Node root = new Node(4);
        Node p = root;
        p.left = new Node(2);
        p.right = new Node(5);
        p.left.left = new Node(1);
        p.left.right = new Node(3);
        Node listHead = solve.treeToDoublyList(root);
        while(listHead.right!=null){
            System.out.print(":");
            System.out.println(listHead.right.val);
            listHead = listHead.right;
        }
    }
}
