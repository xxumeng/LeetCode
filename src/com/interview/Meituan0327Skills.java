package com.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan0327Skills {
    public int minMP(String nums, int c1, int c2){
        int n = nums.length();
        int[][] dp = new int[n+1][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (nums.charAt(i-1)=='T') {
                dp[i][0] = dp[i-1][0];
                continue;
            }else{
                    if (i<=2) dp[i][0] = dp[i-1][0];
                    //上一局使用技能
                    int min = Math.min(dp[i-1][1],dp[i-1][2]);
                    //上上一局使用技能
                    if(i>=3)
                        min = Math.min(min, Math.min(dp[i-2][1],dp[i-2][2]));
                    //上一局或者上上局为T
                    if (i>=3 && (nums.charAt(i-2)=='T' ||  nums.charAt(i-3)=='T'))
                        min = Math.min(min, Math.min(dp[i-1][0],dp[i-2][0]));

                    dp[i][0] = min;

                dp[i][1] = Math.min(Math.min(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + c1;
                dp[i][2] = Math.min(Math.min(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + c2;
            }
//            System.out.println(dp[i][0]+","+dp[i][1]+","+dp[i][2]);
        }
        return Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        String s = in.next();

        Meituan0327Skills t = new Meituan0327Skills();
        int mp = t.minMP(s, c1, c2);
        System.out.println(mp);
    }
}
