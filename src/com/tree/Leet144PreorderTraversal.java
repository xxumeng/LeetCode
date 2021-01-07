package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet144PreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public void traverse(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.empty()){
            while(root!=null){
                s.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = s.pop();
            if(root.right!=null) root = root.next;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return res;
        traverse(root);
        return res;
    }
}
