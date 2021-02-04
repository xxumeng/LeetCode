package com.dynamic;

import java.util.Arrays;
import java.util.Collections;

public class Leet322CoinChange {
    //    动态规划
    public int coinChange(int[] coins, int amount) {
        if(amount<0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i=1; i<=amount; i++){
            for (int coin: coins) {
                if(i-coin<0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
