package com.leetcode.multi.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 17:12
 * @Description: 62. 不同路径
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];

        // 初始化第一列
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }

        // 初始化第一行
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }

        // 递推公式 res[i][j] = res[i - 1][j] + res[i][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int i = new UniquePaths().uniquePaths(3, 7);
        System.out.println(i);

    }
}
