package com.ali0409;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main02 {
    public int[] reverse(int[] nums, int l, int r){
        int n = nums.length;
        if (l>=r || n<=1 || l>n-1 || r<0) return nums;

        int[] tmp = new int[r-l+1];
        for (int i = 0; i <= r-l; i++) {
            tmp[i] = nums[r-i];
        }

        for (int i = 0; i <= r-l; i++) {
            nums[i+l] = tmp[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        Main02 s = new Main02();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int k = in.nextInt();
//        int[][] q = new int[k][2];
        for (int i = 0; i < k; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            nums = s.reverse(nums, l-1, r-1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

    }
}
