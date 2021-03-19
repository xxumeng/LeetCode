package com.dynamic;
/*
* 不限制交易次数k
* */
public class Leet122MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
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
}
