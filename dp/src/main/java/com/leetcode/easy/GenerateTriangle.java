package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 15:35
 * @Description: 118. 杨辉三角
 */
public class GenerateTriangle {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        Integer[][] dp = new Integer[numRows][];

        for (int i = 0; i < numRows; i++) {
            dp[i] = new Integer[i + 1];
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (Integer[] ints : dp) {
            res.add(Arrays.asList(ints));
        }

        return res;
    }

}
