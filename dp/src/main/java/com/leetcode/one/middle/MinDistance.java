package com.leetcode.one.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 14:35
 * @Description: 72. 编辑距离
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        // 如果有为空的，直接返回不为空的长度
        if (len2 * len1 == 0) {
            return len1 + len2;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化 word1 转换成空的情况 第一列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // 初始化 word2 转换成空的情况 第一行
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        // dp[i][j] 表示word1 中的 i-1 转换成 word2 中的 j-1的最小操作数
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
