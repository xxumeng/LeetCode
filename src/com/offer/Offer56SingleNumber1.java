package com.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer56SingleNumber1 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num :nums){
            res = res ^ num;
        }
        int[] result = new int[2];
        System.out.println(result[0]+"---"+result[1]);
        return result;
    }

    public static void main(String[] args) {
        Integer i01 = 59;
        int i02=59;
        System.out.println(i01==i02);
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i03==i04);
        Offer56SingleNumber1 solve = new Offer56SingleNumber1();
        solve.singleNumbers(new int[]{3,2,1,3});


    }
}
