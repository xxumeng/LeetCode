package com.dynamic.maxProfix;
/*
* 每次卖出后必须隔一天才能买入
* */
public class Leet309MaxProfitNextDay {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int dp0_1 = 0,dp0_2 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp1 = dp0_1;
            dp0_1 = Math.max(dp0_1, dp1+prices[i]);
            dp1 = Math.max(dp1, dp0_2 - prices[i]);
            dp0_2 = temp1;
        }
        return dp0_1;
    }
}
