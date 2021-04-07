package com.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int minTime(int[] nums, int n){
        if (n==1) return nums[1];
        int res = 0, s = n;
        if (s<3) res += nums[2];
        else if (s==3){
            res += nums[1] + nums[2] + nums[3];
        }
        while (s>3){
            if (nums[1] + nums[s-1] > 2*nums[2]) res += 2*nums[2] + nums[s] + nums[1];
            else res += 2*nums[1] +nums[s] + nums[s-1];
            s -=2;
        }
        return res;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            if (n<=0) {
                System.out.println(0);
                continue;
            }
            int[] nums = new int[n+1];
            for (int j = 1; j <= n; j++) {
                nums[j] = in.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(m.minTime(nums, n));

        }
    }
}
