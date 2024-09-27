package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 17:07
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            boolean binary = binary(ints, target);
            if (binary) {
                return true;
            }
        }

        return false;
    }


    public boolean binary(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
