package com.offer;

import java.util.*;

public class Offer57TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //set
//        Set<Integer> dict = new HashSet<>();
//        for (int n:nums) {
//            if(dict.contains(target-n)) return new int[]{n, target};
//            dict.add(n);
//        }
//        return new int[]{};

        //浪漫指针
        int i=0,j=nums.length-1;
        while(i<j){
            int tmp = nums[i] + nums[j];
            if (tmp<target) i++;
            else if (tmp>target) j--;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[]{};
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        for(int l=1,r=2; l<r;){
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum<target) r++;
            else if (sum>target) l++;
            else {
                int[] s = new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    s[i-l] = i;
                }
                res.add(s);
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
