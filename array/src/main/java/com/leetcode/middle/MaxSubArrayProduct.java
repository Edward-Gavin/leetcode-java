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
        int res = maxDp[0];
        for (int i = 1; i < length; i++) {
            res = Math.max(res, maxDp[i]);
        }

        return res;

    }
}
