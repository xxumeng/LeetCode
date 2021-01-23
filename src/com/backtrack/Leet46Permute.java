package com.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//无重复数组的全排列
public class Leet46Permute {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录当前的路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums, LinkedList<Integer> track){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
