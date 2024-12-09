package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 19:21
 * @Description: 34. 在排序数组里中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int length = nums.length;

        // 找到target的位置
        int position = binarySearch(nums, target);
        if (position == -1) {
            return new int[]{-1, -1};
        } else {
            int left = position;
            int right = position;

            // 找最小位置
            while (0 < left && nums[left] == target) {
                left--;
            }

            // 找最大位置
            while (right < length && nums[right] == target) {
                right++;
            }

            return new int[]{left + 1, right - 1};

        }
    }

    public static int binarySearch(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
