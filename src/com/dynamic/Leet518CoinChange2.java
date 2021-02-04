package com.dynamic;

public class Leet518CoinChange2 {
    public int change(int amount, int[] coins) {
//        if (coins.length==0 || amount==0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j-coins[i]>=0) dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
