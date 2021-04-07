package com.interview.baidu;

import java.util.Scanner;

public class Main01 {
    public int minStep(String nums){
        int n = nums.length();
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-2; j >=0 ; j--) {
                int cur = nums.charAt(j) - '0';
                if (cur + j == i){
                    System.out.print(cur+" + ");
                    System.out.print(j + " = ");
                    System.out.println(i);
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String num = in.next();
        if (n<=1) {
            System.out.println(0);
            return;
        }
        if (num.charAt(0)-'0' == n-1) {
            System.out.println(1);
            return;
        }
        Main01 t = new Main01();
        System.out.println(t.minStep(num));

    }
}
