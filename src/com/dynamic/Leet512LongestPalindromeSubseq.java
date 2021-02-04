package com.dynamic;

import java.util.Arrays;

public class Leet512LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len==0) return 0;
        if (len==1) return 1;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], 0);
            dp[i][i]=1;
        }
        for (int i = len-1; i >= 0 ; i--) {
            for (int j = i+1; j < len ; j++) {
                if (s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][len-1];
    }
}
