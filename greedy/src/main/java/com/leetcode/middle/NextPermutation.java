package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/12 17:49
 * @Description:
 */
public class NextPermutation {

    public void nextPerMutation(int[] nums) {

        int length = nums.length;

        if (length < 2) {
            return;
        }

        int end = length - 1;
        int cur = length - 2;
        while (end >= 0 && cur >= 0) {
            if (nums[cur] >= nums[end]) {
                end--;
                cur--;
            }
        }



    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
