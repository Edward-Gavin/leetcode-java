package com.leetcode.middle;


/**
 * @author: shiwei10
 * @create: 2024-10-07 17:09
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int length = nums.length;

        int[] dp = new int[length];

        dp[0] = nums[0];

        int res = dp[0];

        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
