package com.weibo.leetcode.greedy;

/**
 * @Author: shiwei10
 * @Date: 2024/4/29 20:00
 * @Description: 53
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            if (sum > result) {
                result = sum;
            }
            if (sum <= 0){
                sum = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(input));
    }
}
