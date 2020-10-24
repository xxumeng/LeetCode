package com.offer;

public class Offer15Count1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        //注意：有可能是负数
        while(n!=0){
            count += n & 1;
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer15Count1 solve = new Offer15Count1();
//        int n = 11111111111111111111111111111101;
//        System.out.println(solve.hammingWeight(n));
        //注意，Integer.valueOf接收的负数是以负号开头的，以1开头的话认为是正数，越界了
        System.out.println(Integer.valueOf("1111111111111111111111111111111",2));
        System.out.println(Math.pow(2,31)-1);
    }
}
