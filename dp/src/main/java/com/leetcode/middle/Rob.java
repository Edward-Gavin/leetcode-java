package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 17:14
 * @Description: 198. 打家劫舍
 */
public class Rob {
    public int rob(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + dp[i - 2]);
        }

        return dp[length];
    }
}
