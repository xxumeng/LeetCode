package com.tree;

public class Offer07BuildTree {
    /*边界问题，并且仅适用于无重复节点*/
    public TreeNode trans(int[] preorder, int[] inorder, int pre_s, int pre_e, int in_s, int in_e){
        if (pre_e-pre_s==0 || in_e-in_s==0) return null;
        TreeNode root = new TreeNode(preorder[pre_s]);
        int i=0;
        for(; i< in_e-in_s; i++){
            if(inorder[i+in_s]==preorder[pre_s]) break;
        }
        root.left = trans(preorder, inorder, pre_s+1, pre_s+i+1, in_s, in_s+i);
        root.right = trans(preorder, inorder, pre_s+i+1, pre_e, in_s+i+1, in_e);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) return null;
        return trans(preorder, inorder,0, preorder.length, 0, inorder.length);

    }
}
