package com.tree;

//p q必定在树中，假设该节点不是q p，并且该节点左右子节点都不含pq，返回null，否则返回该节点
//即上述函数要么返回最近祖先，要么返回null，深度优先
public class Offer68CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
//        if (l!=null && r!=null) return root;
        if(l==null) return r;
        if(r==null) return l;
        return root;
    }
}
