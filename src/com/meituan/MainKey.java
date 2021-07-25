package com.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class MainKey {
    public boolean isKeyString(String temp){
        int n = temp.length();
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);
        if (n%2==0){
            if (chars[0] == chars[n/2] || chars[n/2-1]==chars[n-1]) return true;
        }else {
            if (chars[0] == chars[n/2] || chars[n/2]==chars[n-1]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        MainKey s = new MainKey();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] chars;
        String str = in.next();
        chars = str.toCharArray();
        //求子串
        int res = n;
        for(int i = 0; i < chars.length ; i++) {
            for(int j = i+2; j < chars.length+1 ; j++) {
                String sub = str.substring(i,j);
                if (s.isKeyString(sub)) res++;
            }
        }
        System.out.println(res);
    }
}
