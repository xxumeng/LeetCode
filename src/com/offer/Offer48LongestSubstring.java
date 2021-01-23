package com.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Offer48LongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int l = 0;
//            Set<Character> set = new HashSet<>();
//            while (!set.contains(s.charAt(i))) {
//                set.add(s.charAt(i));
//                l++;
//                len = Math.max(len,l);
//            }
//        }
//        return len;
//    }
    //指针+hash表
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int res=0, i=-1; //i表示左指针
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, s.charAt(j));//找到重复元素所在的坐标，如果在维护的队列内，将其设置为左边界，否则左边界不变。
            dic.put(s.charAt(j),j);
            res = Math.max(res, j-i);
        }
        return res;
    }
    //动态规划+hash表
    // public int lengthOfLongestSubstring(String s) {
    //     Map<Character, Integer> dic = new HashMap<>();
    //     int res = 0, tmp = 0;
    //     for(int j = 0; j < s.length(); j++) {
    //         int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
    //         dic.put(s.charAt(j), j); // 更新哈希表
    //         //tmp < j - i证明没有重复（此时i=-1），当出现重复时，j-i就是长度
    //         tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
    //         res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
    //     }
    //     return res;
    // }

}
