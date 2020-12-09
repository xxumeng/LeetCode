package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Offer34PathSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<Integer> trans(TreeNode root, int sum, List<Integer> tmp){
        if (root==null && sum!=0) return null;
        if(root==null && sum==0) {
            res.add(tmp);
            return tmp;
        }
        sum -= root.val;
        tmp.add(root.val);
        trans(root.left, sum, tmp);
        trans(root.right, sum, tmp);
        return tmp;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tmp = new ArrayList<>();
        trans(root, sum, tmp);
        return res;
    }
}
