package com.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: shiwei10
 * @Date: 2024/10/16 12:54
 */
public class QuickSort {
    public int[] quick(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quick(nums, left, partition - 1);
            quick(nums, partition + 1, right);
        }
        return nums;
    }

    public int partition(int[] nums, int left, int right) {

        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && nums[i] < nums[left]) {
                i++;
            }
            while (i < j && nums[left] < nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }
        swap(nums, i, left);

        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int[] quick = new QuickSort().quick(input, 0, input.length - 1);
        System.out.println(Arrays.toString(quick));
    }
}
