package com.leetcode.multi.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 17:45
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        int M = ch1.length;
        int N = ch2.length;

        int[][] res = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            res[i][0] = 0;
        }

        for (int i = 0; i < N; i++) {
            res[0][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (ch1[i] == ch2[j]) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }

        return res[M][N];
    }
}
