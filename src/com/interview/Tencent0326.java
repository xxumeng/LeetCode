package com.interview;
import java.util.Scanner;
import java.util.Arrays;
public class Tencent0326 {
}

class Main {
    public int minDay(int n, int[] company, int[] sports){
        int[][] dp = new int[n+1][3];
        for(int i=0; i<=n;i++){
            for(int j=0;j<=2;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化 0代表默认
        for(int j=0;j<=2;j++){
            dp[0][j] = 0;
        }
        //从第一天开始
        for(int i =1; i<=n; i++){
            if(company[i-1]==1){
                //公司开门
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]);

            }
            if(sports[i-1]==1){
                //健身房开门
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]);
            }
            //当天休息
            dp[i][2] = Math.min(dp[i-1][0],Math.min(dp[i-1][1],dp[i-1][2])) +1;
        }
        int res = 0;
        res = Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] companny = new int[n];
        int[] sports = new int[n];
        for(int i=0;i<n;i++){
            companny[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            sports[i] = in.nextInt();
        }
        Main t = new Main();
        int res = t.minDay(n, companny, sports);
        System.out.println(res);

    }
}