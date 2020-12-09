package com.offer;

import java.util.Arrays;

public class Offer29MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
