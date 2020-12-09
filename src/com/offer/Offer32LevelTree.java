package com.offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// * Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
// }
public class Offer32LevelTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> nextLevel = new LinkedList<>();
        queue.add(root);
//        while (!queue.isEmpty()||!nextLevel.isEmpty()){
//            List<Integer> tmp = new ArrayList<>();
//            while(!queue.isEmpty()){
//                TreeNode node = queue.poll();
//                if (node.left!=null) nextLevel.add(node.left);
//                if (node.right!=null) nextLevel.add(node.right);
//                tmp.add(node.val);
//            }
//            res.add(tmp);
//            queue.addAll(nextLevel);
//            nextLevel.clear();
//        }
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int levelNum = queue.size();
            for (int i=levelNum;i>0;i--){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
