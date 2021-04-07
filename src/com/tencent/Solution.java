package com.tencent;

import java.util.*;


 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
 }


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
     * @param root TreeNode类 指向二叉树的根
     * @return TreeNode类
     */

    public TreeNode solve (TreeNode root) {
        // write code here
        if (root==null) return null;
        int r=0;
        TreeNode[] trees = new TreeNode[100];
        TreeNode temp = null;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        int cur = 1;
        int l = 1;

        while (!deque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int num = deque.size();
            for (int i = 0; i < num; i++) {
                temp = deque.poll();
                trees[++r] = temp;
                if (temp.val!='#') level.add(temp.val);
                else break;
                if (temp.left!=null && temp.right!=null) {

                    deque.add(temp.left);
                    deque.add(temp.right);
                }
            }
            if (level.size()!=cur) break;
            cur = 2*cur;
            l ++;
        }
        int start = (int) Math.pow(2,l-1) - 1;
        int end = (int) (Math.pow(2, l)-1);
        for (int i = start; i <= end; i++) {
            temp = trees[i];
            temp.left = null;
            temp.right = null;
        }


        return root;

    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine().replace("{","").replace("}","");
//        String[] trees = new String[s.length()];
//        trees = s.split(",");
//        f
//
//
//    }
}