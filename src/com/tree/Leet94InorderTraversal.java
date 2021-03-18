package com.tree;

import java.util.*;
/*
* 1.递归
* 2.非递归，借助栈deque
*   （1）加入栈，并一直向左，直到为空
*   （2）出栈，加入res，当前指向右孩子，回到（1）
* */
public class Leet94InorderTraversal {
    List<Integer> res = new ArrayList<>();
    public void traversal(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return res;
        traversal(root);
        return res;
    }
}
