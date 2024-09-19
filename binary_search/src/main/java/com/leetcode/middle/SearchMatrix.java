package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 18:54
 * @Description: 搜索二维矩阵
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix.length;
        int left = 0;
        int right = length;

        while (left < right) {

            int midArray = (left + right) >> 1;
            boolean contains = binarySearch(matrix[midArray], target);
            int midLength = matrix[midArray].length;

            if (contains) {
                return true;
            } else {
                if (matrix[midArray][midLength - 1] < target) {
                    left = midArray + 1;
                } else {
                    right = midArray;
                }
            }
        }

        return false;
    }

    public boolean binarySearch(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid;
            }
        }

        return false;

    }
}
