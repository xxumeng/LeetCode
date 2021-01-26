package com.string;

public class Offer58ReverseWords {
    public String reverseWords(String s) {
        s = s.trim(); //去除尾部空格
        StringBuilder res = new StringBuilder();
        //双指针
        int i=s.length()-1,j=i;
        while (i>=0){
            while(i>=0 && s.charAt(i)!=' ') i--;
            res.append(s.substring(i+1, j+1) + ' ');
            while(i>=0 && s.charAt(i)==' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
