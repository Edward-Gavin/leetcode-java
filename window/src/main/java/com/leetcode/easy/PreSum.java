package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 18:58
 */
public class PreSum {
    public int preSum(int[] nums, int m, int n) {

        int[] pre = new int[nums.length];
        pre[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        return pre[n] - pre[m - 1];
    }
}
