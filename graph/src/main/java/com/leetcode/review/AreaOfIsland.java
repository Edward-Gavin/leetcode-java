package com.leetcode.review;

/**
 * @Author: shiwei10
 * @Date: 2025/3/28 16:29
 */
public class AreaOfIsland {
    public static void main(String[] args) {


    }

    public int areaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }

        }
        return 0;
    }

    public int dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == 1) {
            return 0;
        }

        grid[r][c] = 2;


        return dfs(grid, r, c + 1)
                + dfs(grid, r, c - 1)
                + dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c);
    }
}
