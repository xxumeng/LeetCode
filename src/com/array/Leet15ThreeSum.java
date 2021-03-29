package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res= new ArrayList<>();
        int n= nums.length;
        if (n<3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if(i>0 && cur==nums[i-1]) continue;
            int l=i+1,r=n-1;
            while (l<r){
                int tmp = cur + nums[l] + nums[r];
                if (tmp==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);

                    while (l<r && nums[l+1]==nums[l]) l++;
                    while (l<r && nums[r-1]==nums[r]) r--;
                    l++;
                    r--;
                }else if (tmp<0) l++;
                else r--;
            }
        }
        return res;
    }
}
