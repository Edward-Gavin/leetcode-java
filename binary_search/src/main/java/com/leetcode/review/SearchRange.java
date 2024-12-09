package com.leetcode.review;


import java.util.Arrays;

/**
 * @Author: shiwei10
 * @Date: 2024/12/9 19:39
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);

        int start = index;
        int end = index;

        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            while (start >= 0 && nums[start] == target) {
                start--;
            }

            while (end < nums.length && nums[end] == target) {
                end++;
            }
        }
        return new int[]{start + 1, end - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;


        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1, 2, 4, 5, 6, 6, 6, 6, 7, 8, 9};
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(input, 6);
        System.out.println(Arrays.toString(ints));

    }
}
