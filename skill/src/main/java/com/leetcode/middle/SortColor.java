package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-09-28 20:45
 */
public class SortColor {
    public void sortColor(int[] nums) {

        int length = nums.length;
        int ptr = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

    }
}
