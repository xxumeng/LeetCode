package com.hot;

public class Hot14LongestCommonPrefix {
    //思路1：纵向比较
    public String longestCommonPrefix(String[] strs){
        //考虑特殊情况
        if(strs == null || strs.length==0){
            return "";
        }

        //最长公共子串不会超过数组中最短的字符串长度
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs.length<minLen){
                minLen =strs[i].length();
                minIdx = i;
            }
        }
        //少用变量
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }

        }
        return strs[minIdx];
    }

    public static void main(String[] args) {
        String[] strs = {"",""};
        System.out.println(new Hot14LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
