package com.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//最长递增子序列（Longest Increasing Subsequence，简写 LIS）
public class Leet300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] top = new int[len+1];
        //堆数
        int heaps = 0;
        for (int i = 0; i < len; i++) {
            //要处理的扑克牌(patience game 的纸牌游戏)
            int poker = nums[i];

            //二分查找找到左边界，作文左边界的堆顶
            int low = 0, high=heaps;
            while (low<high){
                int mid = low + (high-low)/2;
                if (nums[mid] < poker) low = mid+1;
                else if (nums[mid] >= poker) high=mid;
            }
            //没有合适的堆，新建堆
            if (low==heaps) heaps++;
            top[low] = poker;
        }
        return heaps;
    }
}
