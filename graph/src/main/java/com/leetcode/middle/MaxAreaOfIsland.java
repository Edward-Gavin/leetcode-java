package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 11:13
 * @Description: 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    /**
     * 找到最大的岛屿面积，其中0为海洋，1为未访问过的岛屿，2为已经访问过的岛屿
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        int res = 0;

        // 遍历所有的位置，找到岛屿，即 grid[i][j] == 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 搜索当前岛屿相邻的所有点是否也是岛屿，递归搜索
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int i, int j) {

        // 越界 或者 已经被搜索过，返回 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        // 访问当前位置，并将其标记为已经访问过
        grid[i][j] = 2;

        return 1
                + dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1);
    }
}
