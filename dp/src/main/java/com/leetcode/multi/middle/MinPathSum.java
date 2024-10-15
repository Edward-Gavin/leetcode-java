package com.leetcode.multi.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 17:24
 * @Description: 64. 最小路径和
 */
public class MinPathSum {
    public int minPathSum(int[][] grid){

        int M = grid.length;
        int N = grid[0].length;

        int[][] res = new int[M][N];

        // 初始化
        res[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }

        return res[M - 1][N - 1];
    }
}
