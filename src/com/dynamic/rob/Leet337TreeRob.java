package com.dynamic.rob;
import com.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leet337TreeRob {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int helper(TreeNode root){
        if (root==null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int doRob = root.val;
        if (root.left!=null) doRob += helper(root.left.left) + helper(root.left.right);
        if (root.right!=null) doRob += helper(root.right.left) + helper(root.right.right);
        int notRob = helper(root.left) + helper(root.right);
        int res = Math.max(doRob,notRob);
        map.put(root, res);
        return res;
    }
    public int rob(TreeNode root) {
        return helper(root);
    }
}
