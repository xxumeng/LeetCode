package com.tencent;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
    public int minLength(int[] nums, int n){
        if (n<=1) return n;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) stack.push(nums[i]);
            else {
                int cur = stack.peek();
                if (cur+nums[i]==10){
                    stack.pop();
                }else {
                    stack.push(nums[i]);
                }
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ss = in.next();
        System.out.println(ss);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ss.charAt(i)-'0';
        }
        Solution2 s = new Solution2();
        System.out.println(s.minLength(nums,n));

    }
}
