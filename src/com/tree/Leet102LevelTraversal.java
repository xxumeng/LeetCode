package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet102LevelTraversal {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return res;
        queue.add(root);
        TreeNode temp = null;
        while (!queue.isEmpty()){
//            读取队列的元素个数
            int num = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                temp = queue.poll();
                level.add(temp.val);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            res.add(level);
        }
        return res;
    }
}
