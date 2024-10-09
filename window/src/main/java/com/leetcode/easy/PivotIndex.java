package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 17:48
 * @Description: 724. 寻找数组的中心下标
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {

        int sum = 0;
        int leftSum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
