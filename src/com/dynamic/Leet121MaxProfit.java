package com.dynamic;

public class Leet121MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int n = prices.length;
        int minBuy = Integer.MAX_VALUE;
        int res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            temp = prices[i] - minBuy;
            if (temp>res) res = temp;
        }
        return res;
    }
}
