package com.offer;


import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Offer27MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode mirror = new TreeNode(root.val);
        mirror.left = mirrorTree(root.right);
        mirror.right = mirrorTree(root.left);
        return mirror;
    }
    /*
    * 栈暂存，初始化存入root
    * 出栈，并将当前结点的左右结点入栈，改变当前节点的左右结点；
    * 出栈上一步入栈的右节点，改变其左右节点
    * */
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        Offer27MirrorTree solve = new Offer27MirrorTree();

    }
}
