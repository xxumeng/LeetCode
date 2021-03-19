package com.dynamic.maxProfix;
/*
* 当k大于n/2时，相当于不限制次数
* */
public class Leet188MaxProfitLimitK {
    public int maxProfitNotLimitK(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < prices.length; i++) {
            temp = dp0;
            dp0 = Math.max(dp0, dp1+prices[i]);
            dp1 = Math.max(dp1, temp-prices[i]);
        }
        return dp0;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n==0) return 0;
        if (k>n/2) return maxProfitNotLimitK(prices);
        int[][][] dp = new int[n][k+1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i-1==-1){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = - prices[0];
                    continue;
                }
                if (j-1==0){
                    dp[i][0][0] = 0;
                    dp[i][0][1] = Integer.MIN_VALUE;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
}
