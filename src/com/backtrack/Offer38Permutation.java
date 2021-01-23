package com.backtrack;

import java.util.*;

public class Offer38Permutation {
    //如何剪枝，aa不分区是哪个位置的a
    Set<String> res = new HashSet<>();
    char[] letters;
    public String[] permutation(String s) {
        letters = s.toCharArray();
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(s, track);
        return res.toArray(new String[res.size()]);
    }
    public void backtrack(String s, ArrayList<Integer> track){
        if (track.size()==s.length()){
            char[] r = new char[s.length()] ;
            for (int i=0; i<track.size();i++) {
               r[i] = letters[track.get(i)];
            }
            res.add(String.valueOf(r));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (track.contains(i)) continue;
            track.add(i);
            backtrack(s, track);
            track.remove(track.size()-1);
        }
    }
}
