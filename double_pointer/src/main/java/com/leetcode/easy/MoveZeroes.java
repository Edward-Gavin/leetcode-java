package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/10/22 19:01
 * @Description: 283. 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int left = 0;

        while (left < nums.length && nums[left] != 0) {
            left++;
        }

        int right = left + 1;

        while (right < nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1};
        new MoveZeroes().moveZeroes(input);
        for (int i : input) {
            System.out.println(i);
        }

    }
}
