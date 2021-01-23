package com.dynamic;

public class Offer60DicesProbability {
    public double[] dicesProbability(int n) {
        //可能的结果为【n，6n】取值，共有6n-n+1种可能
        double[] res = new double[5*n+1];
        //动态规划：n行，s列（s最大值为6n）；dp[n][s] 表示投掷 n 个骰子，n 个朝上的面的点数之和为 s 的事件出现的次数。
        int[][] dp = new int[n+1][6*n+1];
        //初始化
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 6*n-1; j++) {
                dp[i][j] = 0;
            }
        }
        //一个骰子，s为1~6的次数都是1
        for(int j=1; j<=6;j++){
            dp[1][j] = 1;
        }

        for(int i=2; i<=n;i++){
            for (int j = 1; j <= 6*i; j++) {
                for (int k = 1; k <=6 ; k++) {
                    //i个骰子，面数朝上的和j。 += i-1个骰子，和为j-k
                    if(j-k>0) dp[i][j] += dp[i-1][j-k];
                    else break;
                }
            }
        }
        double div = Math.pow(6, n);
        for (int s = n; s <6*n+1 ; s++) {
            //列举s的所有可能
            res[s-n] = dp[n][s] / div;
        }
        return res;
    }
}
