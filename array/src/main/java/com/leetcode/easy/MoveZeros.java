package com.leetcode.easy;

import java.util.Arrays;

/**
 * @author: shiwei10
 * @create: 2024-09-16 18:33
 */
public class MoveZeros {
    public static void moveZeros(int[] nums){

        int length = nums.length;
        if (length == 0 || length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int k = i;
                for (int j = i + 1; j < length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                        k++;
                    }
                }
            }
        }

    }

    public static void moveZeroToEnd(int[] nums) {


        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1};
        moveZeros(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
