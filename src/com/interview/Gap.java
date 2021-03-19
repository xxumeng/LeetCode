package com.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Gap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i]<nums[j]){
                    res[i] = nums[j]-nums[i];
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
            if (i!=n-1) System.out.print(" ");

        }

    }
}
