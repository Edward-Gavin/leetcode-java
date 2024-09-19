package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 17:13
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int length = nums.length;

        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static int binarySearch(int[] nums, int target) {

        int length = nums.length;

        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid + 1;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }

        return mid;
    }
}
