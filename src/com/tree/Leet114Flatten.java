package com.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Leet114Flatten {
    public void flatten(TreeNode root) {
        if (root==null) return;
        //Deque双端队列，代替Stack
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode cur = stack.removeLast();
            TreeNode left = cur.left, right = cur.right;
            if (right!=null) stack.addLast(right);
            if (left!=null) stack.addLast(left);
            if (pre!=null){
                pre.left = null;
                pre.right = cur;
            }
            pre = cur;
        }
    }
}
