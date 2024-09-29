package com.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 15:35
 * @Description: 119. 杨辉三角II
 */
public class GenerateTriangleV2 {


    public List<Integer> generate(int rowIndex) {

        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }

        Integer[][] dp = new Integer[rowIndex + 1][];

        for (int i = 0; i < rowIndex + 1; i++) {
            dp[i] = new Integer[i + 1];
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return Arrays.asList(dp[rowIndex]);
    }
}
