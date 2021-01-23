package com.dynamic;

public class Offer60DicesProbability {
    public double[] dicesProbability(int n) {
        //可能的结果为【n，6n】取值，共有6n-n+1种可能
        double[] res = new double[5*n+1];
        int[][] dp = new int[n+1][6*n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 6*n-1; j++) {
                dp[i][j] = 0;
            }
        }
        for(int j=1; j<=6;j++){
            dp[1][j] = 1;
        }
        for(int i=2; i<n+1;i++){
            for (int j = 0; j < 6*i+1; j++) {
                for (int k = 1; k <=6 ; k++) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double div = Math.pow(6, n);
        for (int s = n; s <5*n-1 ; s++) {
            res[s-n] = dp[n][s] / div;
        }
        return res;
    }
}
