package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 17:26
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {

        int length = nums.length;

        int left = 0;
        int right = length;
        int mid;

        // 左闭右开区间
        while (left < right) {

            mid = (left + right) >> 1;

            if (nums[mid] < target) {

                left = mid + 1;

            } else if (target < nums[mid]) {

                right = mid;

            } else {

                return mid;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 3, 5, 9, 12};
        int i = binarySearch(ints, 12);
        System.out.println(i);
    }
}
