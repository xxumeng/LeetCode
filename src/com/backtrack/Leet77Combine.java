package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Leet77Combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, track, 1);
        return res;
    }
    public void backtrack(int n, int k, List<Integer> track, int start){
        if (track.size()==k) res.add(new ArrayList<>(track));
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, track, i+1);
            track.remove(track.size()-1);
        }
    }
}
