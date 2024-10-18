package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/17 10:29
 * @Description: 152. 乘积最大子数组
 */
public class MaxSubArrayProduct {
    public int maxProduct(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int[] maxDp = new int[length];
        int[] minDp = new int[length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                maxDp[i] = Math.max(maxDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(minDp[i - 1] * nums[i], nums[i]);
            } else {
                maxDp[i] = Math.max(minDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(maxDp[i - 1] * nums[i], nums[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, maxDp[i]);
        }

        return res;

    }


    public int max(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int[] maxDP = new int[length];
        int[] minDP = new int[length];

        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(minDP[i - 1] * nums[i], nums[i]);
            } else {
                maxDP[i] = Math.max(minDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], nums[i]);
            }
        }

        int res = maxDP[0];
        for (int j : maxDP) {
            res = Math.max(res, j);
        }

        return res;
    }
}
