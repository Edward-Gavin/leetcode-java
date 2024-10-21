package com.leetcode.one.middle;

import java.util.Arrays;

/**
 * @Author: shiwei10
 * @Date: 2024/10/21 19:50
 * @Description: 300. 最长递增子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 0;

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}

