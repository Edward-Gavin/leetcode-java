package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-09-28 20:45
 * @Description: 75. 颜色分类
 */
public class SortColor {
    public void sortColor(int[] nums) {

        int length = nums.length;
        int ptr = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
               swap(nums, i, ptr);
                ptr++;
            }
        }

        for (int i = ptr; i < length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }
        }

    }

    public void sortColor2(int[] nums) {

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int cur = 0;

        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                cur++;
                left++;
            } else if (nums[cur] == 1) {
                cur ++;
            } else {
                swap(nums, cur, right);
                right--;
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
