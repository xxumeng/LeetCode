package com.traceback;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer24PathSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void traceback(TreeNode root, int sum){
        if(root==null) return;
        path.add(root.val);
        if (sum-root.val==0 && root.left==null && root.right==null) res.add(new LinkedList(path));
        traceback(root.left, sum-root.val);
        traceback(root.right, sum-root.val);
        path.removeLast();

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        traceback(root, sum);
        return res;
    }
}
