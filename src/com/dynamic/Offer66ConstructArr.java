package com.dynamic;

public class Offer66ConstructArr {
    public int[] constructArr(int[] a) {
        if (a.length==0) return new int[0];
        int[] b = new int[a.length];
        //上三角
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        //下三角
        int tmp=1;
        for (int i = a.length-2; i >=0 ; i--) {
            tmp *= a[i+1];
            b[i] = b[i] * tmp;
        }
        return b;
    }
}
