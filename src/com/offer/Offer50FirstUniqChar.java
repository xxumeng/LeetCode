package com.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dict = new LinkedHashMap<>();
        for (char c:s.toCharArray()) {
            if(!dict.containsKey(c)) dict.put(c, false);
            else dict.put(c, true);
        }
        for (Map.Entry<Character,Boolean> d:dict.entrySet()) {
            if (d.getValue()==false) return d.getKey();
        }
        return ' ';
    }
}
