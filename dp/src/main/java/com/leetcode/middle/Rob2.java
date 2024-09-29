package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 18:46
 * @Description: 213. 打家劫舍II
 */
public class Rob2 {
    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[1], nums[0]);
        }

        return Math.max(rangeRob(nums, 0, length - 2 ), rangeRob(nums, 1, length - 1));
    }

    public int rangeRob(int[] nums, int start, int end) {

        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }
}
