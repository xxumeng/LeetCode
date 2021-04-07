package com.interview;

public class MinSum {
    public int minSum(int[] nums){
        if(nums.length==0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i< nums.length;i++){
            sum= Math.min(sum+nums[i], nums[i]);
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, -7, 2, -5};
        MinSum solve = new MinSum();
        System.out.println(solve.minSum(nums));
    }
}
