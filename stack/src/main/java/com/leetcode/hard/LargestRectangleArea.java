package com.leetcode.hard;

/**
 * @Author: shiwei10
 * @Date: 2024/10/23 20:00
 * @Description: 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        int length = heights.length;

        int[] minLeftIndex = new int[length];
        int[] minRightIndex = new int[length];


        // 左边第一个小
        minLeftIndex[0] = -1;
        for (int i = 0; i < length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = minLeftIndex[t];
            }
            minLeftIndex[i] = t;
        }


        // 右边第一个小
        minRightIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < length && heights[t] >= heights[i]) {
                t = minRightIndex[t];
            }
            minRightIndex[i] = t;
        }


        // 求和
        for (int i = 0; i < length; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            res = Math.max(res, sum);
        }


        return res;
    }
}
