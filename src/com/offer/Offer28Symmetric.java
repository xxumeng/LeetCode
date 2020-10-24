package com.offer;

public class Offer28Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return  nodeSame(root.left,root.right);

    }
    public boolean nodeSame(TreeNode left, TreeNode right) {
        if(left.val!=right.val) return false;
        if(left.left!=null && right.right!=null) nodeSame(left.left, right.right);
        else return false;
        if(left.right!=null && right.left!=null) nodeSame(left.right, right.left);
        else return false;
        return true;
    }
}
