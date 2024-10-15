package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 11:44
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }


    public int dfs(int[][] grid, int r, int c) {

        // 边界，多一条边
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 1;
        }

        // 海洋格子，多一条边
        if (grid[r][c] == 0) {
            return 1;
        }

        // 访问过的陆地，返回，与周长无关
        if (grid[r][c] != 1) {
            return 0;
        }

        // 标记访问过
        grid[r][c] = 2;

        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
