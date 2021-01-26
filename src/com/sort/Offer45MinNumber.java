package com.sort;

import java.util.Arrays;

public class Offer45MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x+y).compareTo(y+x));
        quickSort(strs);
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str);
        }
        return res.toString();
    }

    public void quickSort(String[] strs){
        int left=0, right=strs.length-1;
        partition(strs, left, right);
    }
    public void partition(String[] strs, int left, int right){
        if (left>=right) return;
        int pivot = left, end = right;
        System.out.println(strs[pivot]);
        while (left<right){
            while (left<right && Long.valueOf(strs[pivot]+strs[right])<=Long.valueOf(strs[right]+strs[pivot])) right--;
            while (left<right && Long.valueOf(strs[pivot]+strs[left])>=Long.valueOf(strs[left]+strs[pivot])) left++;
//            System.out.println(strs[left]);
//            System.out.println(strs[right]);
            if(left<right) swap(strs, left, right);
        }
        swap(strs, pivot, left);
        System.out.println(Arrays.toString(strs));
        if (pivot<left-1) partition(strs, pivot, left-1);
        if(left+1<end) partition(strs, left+1, end);
    }
    public void swap(String[] strs, int i, int j){
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9,1};
        Offer45MinNumber solve = new Offer45MinNumber();
        System.out.println(solve.minNumber(nums));
    }
}
