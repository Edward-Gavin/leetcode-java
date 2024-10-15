package com.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 12:00
 * @Description: 827. 最大人工岛
 */
public class LargestIsland {
    public int largestIsland(int[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        Map<Integer, Integer> map = new HashMap<>();
        // 岛屿编号
        int index = 2;
        // 深搜遍历，计算岛屿的面积，并存储到map中
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    map.put(index, area);
                    index++;
                }
            }
        }

        if (map.isEmpty()) {
            return 1;
        }

        // 深搜遍历，找到所有的海洋格子，搜一次，看是否能连接两个岛屿
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> nearIsland = nearIsland(grid, i, j);

                    // 没有岛屿
                    if (nearIsland.isEmpty()) {
                        continue;
                    }

                    // 计算相邻的岛屿面积和
                    int nearIslandSum = 1;
                    for (Integer integer : nearIsland) {
                        nearIslandSum += map.get(integer);
                    }

                    // 最大的岛屿面积
                    res = Math.max(res, nearIslandSum);
                }
            }
        }

        return res == 0 ? map.get(2) : res;
    }

    public int dfs(int[][] grid, int r, int c, int index) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = index;

        return 1 + dfs(grid, r + 1, c, index)
                + dfs(grid, r - 1, c, index)
                + dfs(grid, r, c + 1, index)
                + dfs(grid, r, c - 1, index);
    }

    public Set<Integer> nearIsland(int[][] grid, int r, int c) {
        // 当前海洋格子相邻的岛屿
        Set<Integer> near = new HashSet<>();

        if (r + 1 >= 0 && r + 1 < grid.length && c >= 0 && c < grid[0].length && grid[r + 1][c] != 0) {
            near.add(grid[r + 1][c]);
        }
        if (r - 1 >= 0 && r - 1 < grid.length && c >= 0 && c < grid[0].length && grid[r - 1][c] != 0) {
            near.add(grid[r - 1][c]);
        }
        if (r >= 0 && r < grid.length && c + 1 >= 0 && c + 1 < grid[0].length && grid[r][c + 1] != 0) {
            near.add(grid[r][c + 1]);
        }
        if (r >= 0 && r < grid.length && c - 1 >= 0 && c - 1 < grid[0].length && grid[r][c - 1] != 0) {
            near.add(grid[r][c - 1]);
        }
        return near;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
        int i = new LargestIsland().largestIsland(grid);
        System.out.println(i);
    }
}
