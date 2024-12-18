package com.leetcode.one.review;

/**
 * @Author: shiwei10
 * @Date: 2024/12/6 18:56
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {


        int len1 = word1.length();
        int len2 = word2.length();

        if (len2 * len1 == 0) {
            return len2 + len1;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }


        for (int i = 0; i < len2; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }


        return dp[len1][len2];
    }

}
