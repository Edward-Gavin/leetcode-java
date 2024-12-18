package com.leetcode.multi.middle;

/**
 * @Author: shiwei10
 * @Create: 2024-10-15 20:45
 * @Description:
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int r = word1.length();
        int c = word2.length();

        int[][] dp = new int[r + 1][c + 1];

        // 初始化
        for (int i = 0; i <= r; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= c; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[r][c];
    }
}
