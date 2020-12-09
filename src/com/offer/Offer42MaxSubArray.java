package com.offer;
//两个变量，一个不断地寻找连续最大值
//一个记录这个过程中得到的最大值
public class Offer42MaxSubArray {
    public int maxSubArray(int[] nums) {
        int tmp=nums[0], max=nums[0];
        int i=0;
        for (int num : nums){
            i++;
            if (i==1) continue;
            if(tmp+num<=num){
                tmp = num;
            }else{
                tmp = tmp+num;
            }
            if(tmp>max) max = tmp;
            System.out.println(max);
        }
        return max;
    }

    public static void main(String[] args) {
        Offer42MaxSubArray solve = new Offer42MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        solve.maxSubArray(nums);
    }
}
