package com.dynamic;

import java.util.Arrays;

public class Leet416CanPartition {
    public boolean canPartition(int[] nums) {
        //分割等和子集 -> 数组中有可以恰好组成sum/2的方法
        int sum = 0;
        for (int n:nums) {
            sum+=n;
        }
        if (sum%2!=0) return false;

        boolean[] dp = new boolean[sum/2+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
                if (j==sum/2 && dp[j]) return true;
            }
        }
        return dp[sum/2];
    }
}
