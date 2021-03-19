package com.greed;

import java.util.Arrays;
import java.util.Comparator;

public class Leet435EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0) return 0;
        //end升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval:intervals) {
            if (interval[0]>=x_end){
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length-count;
    }
}
