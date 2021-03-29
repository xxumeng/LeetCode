package com.array;

public class Leet33SearchRevolve {
    public int search(int[] nums, int target) {
        int n= nums.length;
        if (n==0) return -1;
        int l=0, r= n-1;
        while (l<=r){
            int mid = (r-l)/2 + l;
            if (nums[mid]==target) return mid;
            //左侧有序
            if (nums[l]<= nums[mid]){
                if (nums[l]<=target && target<nums[mid]) r = mid - 1;
                else l = mid + 1;
            }else {
                //右侧有序
                if (target > nums[mid] && target<=nums[r]) l = mid + 1;
                else r = mid - 1;
            }
         }
        return -1;
    }
}
