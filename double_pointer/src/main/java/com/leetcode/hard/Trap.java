package com.leetcode.hard;

/**
 * @author: shiwei10
 * @create: 2024-09-21 15:09
 * @Description: 42. 接雨水
 */
public class Trap {

    public static int trap(int[] height) {

        int length = height.length;

        int res = 0;

        int[] lMax = new int[length];
        lMax[0] = height[0];

        int[] rMax = new int[length];
        rMax[length - 1] = height[length - 1];

        for (int i = 1; i < length; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        for (int i = length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        for (int i = 0; i < length; i++) {
            res += Math.max(Math.min(lMax[i], rMax[i]) - height[i], 0);
        }

        return res;
    }

    public static int trapV2(int[] height) {
        int length = height.length;
        int l = 1;
        int r = length - 2;

        int lmax = height[0];
        int rmax = height[length - 1];

        int res = 0;

        while (l <= r) {
            if (lmax <= rmax) {
                res += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l++]);
            } else {
                res += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r++]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4, 2, 0, 3, 2, 5};
        int temp = trapV2(ints);
        System.out.println(temp);
    }
}
