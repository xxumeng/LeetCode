package com.dynamic;

public class Offer47MaxValue {
    public int maxValue(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int i=0,j=0;
        while(i<m || j<n){
            // 填充行
            if(i<m){
                for(int l=j; l<n; l++){
                    if(i==0) {
                        dp[i][l] = l>0? dp[i][l-1] + grid[i][l] : grid[i][l];
                    }
                    else dp[i][l] = Math.max(dp[i-1][l], dp[i][l-1]) + grid[i][l];
                }
                i++;
            }
            //填充列
            if (j<n){
                for(int r=i; r<m; r++){
                    if (j==0){
                        dp[r][j] = r>0 ? dp[r-1][j]+ grid[r][j] : grid[r][j];
                    }
                    else dp[r][j] = Math.max(dp[r-1][j], dp[r][j-1]) + grid[r][j];
                }
                j++;
            }

        }
        return dp[m-1][n-1];
    }
}
