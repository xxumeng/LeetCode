package com.offer;

import java.util.Arrays;

public class Offer29SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        //行向右到头；列到下到头； 行向左到头；列向上到头
        int l=0, r=matrix[0].length-1, t=0, b=matrix.length-1; 
        int[] res = new int[(r+1)*(b+1)];
        int cur =0;
        while(true){
            for (int i = l; i<= r; i++) res[cur++] = matrix[t][i];
            if(++t>b) break;
            for (int i=t; i<=b; i++) res[cur++] = matrix[i][r];
            if(--r<l) break;
            for (int i=r; i>=l; i--) res[cur++] = matrix[b][i];
            if(--b<t) break;
            for(int i=b; i>=t; i--) res[cur++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1},{2}};
        int[][] matrix = {{2,5,8},{4,0,-1}};
        Offer29SpiralOrder solve = new Offer29SpiralOrder();
        int[] res = solve.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));

    }
}
