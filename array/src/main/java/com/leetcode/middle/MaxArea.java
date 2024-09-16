package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-09-16 19:42
 */
public class MaxArea {
    public int maxArea(int[] height){

        int res = 0;

        int length = height.length;

        for (int i = 0; i < length; i++) {

            for (int j = i+1; j < length; j++) {

                int high = Math.min(height[i], height[j]);
                int len = j - i;

                res = Math.max(res, high * len);
            }

        }

        return res;
    }

    public int maxArea2(int[] height){

        int i = 0;
        int j = height.length -1;
        int res = 0;

        // 固定长度，剪枝，长度固定，只有最短的一边移动才可能面积更大，最长的一边移动面积肯定会更小
        while (i < j) {

            int s;
            if (height[i] < height[j]) {
                s = (j - i) * height[i];
                i++;
            } else {
                s = (j - i) * height[j];
                j--;
            }


            res = Math.max(res, s);

        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        MaxArea maxArea = new MaxArea();
        int i = maxArea.maxArea2(nums);
        System.out.println(i);
    }
}
