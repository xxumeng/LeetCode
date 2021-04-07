package com.interview;

import java.util.Scanner;

public class Meituan0327Max {
    public int maxSum(int[] nums, int k){
        int n = nums.length;
        if (n<k) return -1;
        int max_sum = 0;
        int[] dp = new int[n];
        for (int i=0; i<k;i++){
            max_sum ^= nums[i];
            dp[i] = Math.max(dp[i-1], max_sum);

        }
        int sum = max_sum;
        for (int i = k; i < n; i++) {
            sum = sum ^ nums[i-k] ^ nums[i];
            max_sum = Math.max(sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Meituan0327Max t = new Meituan0327Max();
        int res = t.maxSum(nums, k);
        System.out.println(res);
    }
}
