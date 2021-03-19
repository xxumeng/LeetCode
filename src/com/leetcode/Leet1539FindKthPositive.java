package com.leetcode;

import java.util.Scanner;
/*二分查找
* 左右边界情况处理
* 转化为寻找小于k的左边界
* 终止条件是k大于左侧，小于等于右侧
* */
public class Leet1539FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int l=0,r=arr.length-1,mid=0;
        if (k<arr[0]) return k;
        if (k>arr[r]-r-1) return arr[r]+k-(arr[r]-r-1);
        while (l<=r){
            mid = (r-l)/2 + l;
            //当前缺失数量
            int temp = arr[mid]-mid-1;
            // System.out.println(temp);
            // if ((k==temp && mid-1>=0 && k==arr[mid-1]-mid) || k<=temp) r = mid-1;
            if (k<=temp) r = mid-1;
            else if (k> temp && k<=arr[mid+1]-mid-2) return arr[mid]+k-temp;
                //else if (k==temp &&  k<=arr[mid+1]-mid-2) return arr[mid-1]+k-(arr[mid-1]-mid);
            else if(k>temp) l=mid+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Leet1539FindKthPositive t = new Leet1539FindKthPositive();
        int res = t.findKthPositive(arr, k);
        System.out.println(res);
    }
}
