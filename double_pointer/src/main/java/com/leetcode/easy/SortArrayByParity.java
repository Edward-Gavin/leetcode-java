package com.leetcode.easy;

/**
 * @author: shiwei10
 * @create: 2024-09-21 15:47
 * @Description: 905. 按奇偶排序数组
 */
public class SortArrayByParity {

    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static int[] sortArrayByParity(int[] nums) {

        int length = nums.length;

        if (length == 1 || length == 0) {
            return nums;
        }

        int start = 0;
        int end = length - 1;

        while (start < end) {
            if (nums[start] % 2 == 0) {
                start++;
            } else {
                swap(nums, start, end);
                end--;
            }

            if (nums[end] % 2 == 1) {
                end--;
            } else {
                swap(nums, start, end);
                start++;
            }
        }


        return nums;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4,5,2,7};
        int[] ints1 = sortArrayByParity(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
