package com.tree;

public class Leet101Symmetric {
    public boolean helper(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l==null || r==null) return false;
        return l.val==r.val && helper(l.left,r.right)&&helper(r.left,l.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
}
