package com.offer;

public class Offer56Single2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
            System.out.println(ones);
            System.out.println(twos);
        }
        return ones;
    }
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, tmps=0;
        for(int num : nums){
            tmps = ones ^ num & ~twos;
            twos = (~twos & (~ones & twos)|(ones & num))|(twos & ~ones & (twos ^ num));
            ones = tmps;
            System.out.println(ones);
            System.out.println(twos);
        }
        return ones;
    }

    public static void main(String[] args) {
        Offer56Single2 solve = new Offer56Single2();
        System.out.println(solve.singleNumber(new int[]{3,4,3,3}));
        System.out.println("-----");
        System.out.println(solve.singleNumber2(new int[]{3,4,3,3}));
    }
}
