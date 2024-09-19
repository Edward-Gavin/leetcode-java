package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 19:44
 * @Description: 33. 搜索旋转排序数组
 */
public class NSearch {
    public int search(int[] nums, int target) {

        int length = nums.length;

        // 找到旋转的点
        int position = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i-1] > nums[i]) {
                position = i;
                break;
            }
        }

        // 左侧二分
        int lPos = binarySearch(nums, 0, position, target);

        // 右侧二分
        int rPos = binarySearch(nums, position, length, target);

        if (lPos == -1 && rPos == -1) {
            return -1;
        }

        if (lPos == -1) {
            return rPos;
        } else {
            return lPos;
        }

    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
