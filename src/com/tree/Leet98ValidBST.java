package com.tree;

public class Leet98ValidBST {
    public boolean helper(TreeNode root, long lower, long upper){
        if (root==null) return true;
        if (root.val<=lower || root.val>=upper) return false;
        return helper(root.left,lower,root.val) && helper(root.right,root.val,upper);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
