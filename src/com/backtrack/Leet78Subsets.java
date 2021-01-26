package com.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet78Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, 0);
        return res;
    }
    public void backtrack(int[] nums,  List<Integer> track, int start){
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track, i+1);
            track.remove(track.size()-1);
        }
    }
}
