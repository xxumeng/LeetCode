package com.hot;

import java.util.HashMap;
import java.util.*;

public class Hot13RomanToInteger {
    private int getValue(char ch){
        switch (ch){
            case 'I' :return 1;
            case 'V':return 5;
            case 'X' :return 10;
            case 'L':return 50;
            case 'C' :return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Map<String, Integer> specialMap = new HashMap<String, Integer>();
        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);
        if (specialMap.containsKey(s)){
            return specialMap.get(s);
        }

        int res = 0;
        int flag = 0;
        for (int i=0; i< s.length(); i++){
            if(flag==1){
                flag=0;
                continue;
            }
            if (i<s.length()-1 && specialMap.containsKey(s.substring(i, i+2)) && map.get(s.charAt(i))< map.get(s.charAt(i+1))){
                System.out.println(s.substring(i, i+2));
                res += specialMap.get(s.substring(i, i+2));
                flag = 1;
            }else{
                res += map.get(s.charAt(i));
            }

        }
        return res;

    }

    public static void main(String[] args) {
        String s = "III";
        Hot13RomanToInteger solve = new Hot13RomanToInteger();
        System.out.println(solve.romanToInt(s));
    }

}
