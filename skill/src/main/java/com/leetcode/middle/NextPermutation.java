package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/11/22 14:08
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 找到 最后一个顺序交换的点
        int last = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                last = i - 1;
                break;
            }
        }

        //
        if (last != -1) {
            int change = last+1;
            for (int i = change; i < nums.length; i++) {
                if (nums[i] > nums[last]) {
                    change = i;
                } else {
                    break;
                }
            }

            swap(nums, last, change);

            for (int i = 1; i <= (nums.length - last) / 2; i++) {
                swap(nums, i + last, nums.length - i);
            }

        }else{
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - i - 1);
            }
        }
    }

    public void swap(int[] num, int i, int j) {
        int mid = num[i];
        num[i] = num[j];
        num[j] = mid;
    }
}
