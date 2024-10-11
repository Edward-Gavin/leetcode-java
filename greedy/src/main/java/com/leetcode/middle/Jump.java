package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 20:34
 * @Description: 45. 跳跃游戏 II
 */
public class Jump {
    public int jump(int[] nums) {

        int length = nums.length;
        int end =0;
        int maxPos = 0;
        int res = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int jump1 = jump.jump(new int[]{2, 3, 1, 1, 4, 2, 1});
        System.out.println(jump1);

    }
}
