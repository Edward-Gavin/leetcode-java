package com.leetcode.review;

/**
 * @Author: shiwei10
 * @Date: 2024/10/22 19:37
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int s;
            if (height[left] < height[right]) {
                s = (right - left) * height[left];
                left++;
            } else {
                s = (right - left) * height[right];
                right--;
            }

            res = Math.max(res, s);

        }



        return res;
    }
}
