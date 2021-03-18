package com.tree;
/*
* 不能仅仅传递一个root，判断其左右子节点是否满足要求
* 防止左子树的右孩子不左子树节点大，却比根节点小以及右..两种情况
* 使用lower upper，会把上述根节点的上下界也传递进来
* */

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
