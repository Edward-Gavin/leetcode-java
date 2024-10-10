package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 13:00
 * @Description: 209. 长度最小的子数组
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {

        int length = nums.length;

        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int i = new MinSubArrayLen().minSubArrayLen(target, ints);
        System.out.println(i);
    }
}
