package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Create: 2024-10-13 23:27
 * @Description: 200. 岛屿数量
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public int dfs(char[][] grid, int r, int c) {

        // 终止条件
        if (c < 0 || r < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return 0;
        }

        // 标记访问过
        grid[r][c] = '2';

        return 1
                + dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c + 1)
                + dfs(grid, r, c - 1);
    }
}
