//package com.interview;
//
//import java.util.Scanner;
//
//public class Meituan0327Blocks {
//    public boolean validPalindrome(String s) {
//        int low = 0, high = s.length() - 1;
//        while (low < high) {
//            char c1 = s.charAt(low), c2 = s.charAt(high);
//            if (c1 == c2) {
//                ++low;
//                --high;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//    public int compare(int[] nums1, int[] nums2){
//        //第一个数是否比第二个数大 返回1
//        if (nums1.length<nums2.length) return 1;
//        if (nums1.length>nums2.length) return -1;
//        int len = nums1.length;
//        for (int i = 0; i < len; i++) {
//            if (nums1[i] > nums2[i]) return 1;
//            if (nums1[i] < nums2[i]) return -1;
//        }
//        //相等
//        return 0;
//    }
//
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//            }
//        }
//
//    }
//}
