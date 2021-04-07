package com.array;

public class Leet42Trap {
    public int trap(int[] height){
        int size = height.length;
        if (size==0) return 0;

        int res = 0;
        int[] L = new int[size];
        int[] R = new int[size];

        //对于每一个元素，包括自己在内的左侧最大值
        L[0] = height[0];
        for (int i = 1; i < size; i++) {
            L[i] = Math.max(L[i-1],height[i]);
        }
        //对于每一个元素，包括自己在内的右侧最大值
        L[size-1] = height[size-1];
        for (int i = size-2; i >=0; i--) {
            L[i] = Math.max(L[i+1],height[i]);
        }

        //一次遍历
        for (int i = 0; i < size; i++) {
            res += Math.min(R[i], L[i]) - height[i];
        }
        return res;
    }
}
