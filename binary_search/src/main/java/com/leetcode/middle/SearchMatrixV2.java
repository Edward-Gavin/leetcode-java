package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/12/9 19:23
 */
public class SearchMatrixV2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = binarySearchFirstColumn(matrix, target);
        if (i == -1) {
            return false;
        }

        return binarySearchRow(matrix[i], target);
    }


    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1;
        int high = matrix.length - 1;

        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public boolean binarySearchRow(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid;
            }
        }
        return false;
    }
}
