package com.offer;

import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.Queue;

public class Offer13BFS {
    public int locSum(int i, int j){
        int sum = 0;
        while(i!=0){
            sum += i % 10;
            i = i/10;
        }
        while(j!=0){
            sum += j % 10;
            j = j/10;
        }
        return sum;
    }
    public int movingCount(int m, int n, int k) {
        if (m==0 || n==0) return 0;
        if(k>=m*n) return m*n;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        int res = 0;
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            System.out.println(cur[0] + "," + cur[1]);
            res += 1;
            //向右
            int[] r = new int[2];
            r[0] = cur[0];
            r[1] = cur[1]+1;
            if(r[1]<n && locSum(r[0],r[1])<=k && vis[r[0]][r[1]]==false){
                queue.offer(r);
                vis[r[0]][r[1]] = true;
            }
            //向下
            int[] b = new int[2];
            b[0] = cur[0]+1;
            b[1] = cur[1];
            if(b[0]<m && locSum(b[0],b[1])<=k && vis[b[0]][b[1]]==false){
                queue.offer(b);
                vis[b[0]][b[1]] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer13BFS solve = new Offer13BFS();
        System.out.println(solve.movingCount(36,11,15));
    }
}
