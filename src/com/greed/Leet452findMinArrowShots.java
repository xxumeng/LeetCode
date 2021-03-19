package com.greed;

import java.util.Arrays;
import java.util.Comparator;

public class Leet452findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0) return 0;
        //end升序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        //不重叠区间数
        int count = 1;
        int x_end = points[0][1];
        for (int[] interval:points) {
            if (interval[0]>x_end){
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
