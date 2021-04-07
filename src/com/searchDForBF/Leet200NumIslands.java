package com.searchDForBF;

public class Leet200NumIslands {
    public void dfs(char[][] grid, int row, int col){
        int nr = grid.length, nc = grid[0].length;
        if (row<0 || col<0 || row>=nr || col>=nc || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
    }
    public int numIslands(char[][] grid) {
        int nums = 0;
        int nr = grid.length, nc = grid[0].length;
        if (nr==0) return nums;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid, i, j);
                    nums++;
                }

            }
        }
        return nums;
    }
}
