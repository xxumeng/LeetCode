package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer34PathSum {
//    插入、删除操作频繁，array也可以，都是在尾部插入删除
//    注意终止条件
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new ArrayList<>();
    public void backtrack(TreeNode root, int sum){
        if (root==null) return;
        sum -=root.val;
        track.add(root.val);
        if(sum==0 && root.left==null && root.left==null) {
            res.add(new LinkedList(track));
        }
        backtrack(root.left, sum);
        backtrack(root.right, sum);
        track.remove(track.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        backtrack(root, sum);
        return res;
    }
}
