package com.tree;

public class Leet96DifferSearchTrees {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        nums[1]=1;
        for (int k = 2; k <=n ; k++) {
            for (int j = 1; j <= k; j++) {
                nums[k] += nums[j-1]*nums[k-j];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        Leet96DifferSearchTrees t = new Leet96DifferSearchTrees();
        System.out.println(t.numTrees(3));
    }
}
