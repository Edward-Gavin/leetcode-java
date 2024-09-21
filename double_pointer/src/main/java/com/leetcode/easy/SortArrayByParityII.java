package com.leetcode.easy;

/**
 * @author: shiwei10
 * @create: 2024-09-21 15:18
 * @Describe: 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {

    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static int[] sortArrayByParityII(int[] nums) {

        int length = nums.length;

        if (length == 0 || length == 1) {
            return nums;
        }

        int odd = 0;
        int even = 1;

        int last = length - 1;

        while (odd < length && even < length) {

            if (nums[last] % 2 == 0) {
                swap(nums, odd, last);
                odd += 2;
            } else {
                swap(nums, even, last);
                even += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4,2,5,7};
        int[] ints1 = sortArrayByParityII(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
