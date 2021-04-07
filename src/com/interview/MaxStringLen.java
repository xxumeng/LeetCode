package com.interview;

import java.util.*;

/*
https://blog.csdn.net/qq_41999455/article/details/105040128
* n个长度不一的字符串(非递减)，组成最长的非递减序列，求最长长度
* */
public class MaxStringLen {
    public int maxStringLen(List<String> lists){
        int[] dp = new int[lists.size()];
        for (int i=lists.size()-1; i>=0; i--) {
            String cur = lists.get(i);
            for (int j = i; j < lists.size(); j++) {
                if (i==j){
                    dp[i] = cur.length();
                    continue;
                }
                String temp = lists.get(j);
                if (cur.charAt(cur.length()-1) <= temp.charAt(0))
                    dp[i] = Math.max(dp[i], cur.length()+dp[j]);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n==0){
            System.out.println(0);
            return;
        }
        List<String> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(in.next());
        }
        Collections.sort(lists);
        MaxStringLen t = new MaxStringLen();
        int res = t.maxStringLen(lists);
        System.out.println(res);
    }
}
