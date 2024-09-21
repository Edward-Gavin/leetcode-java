package com.leetcode.middle;

import java.util.Arrays;

/**
 * @author: shiwei10
 * @create: 2024-09-21 17:51
 * @Description: 881 救生艇
 */
public class NumRescueBoat {
    public static int numRescueBoat(int[] nums, int limit) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int res = 0;

        while (left <= right) {
            int weight = nums[left] + nums[right];
            if (weight <= limit) {
                left++;
            }
            right--;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,2};
        int temp = numRescueBoat(ints,3);
        System.out.println(temp);
    }
}
