package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 20:08
 * @Description: 55. 跳跃游戏
 */
public class CanJump {
    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int i = nums.length - 2;
        int j = nums.length - 1;

        while (i >= 0) {
            if (nums[i] > j - i) {
                j = i;
            }
            i--;
        }

        return j == 0;
    }


    public boolean canJumpV2(int[] nums) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] res = {2, 3, 1, 1, 4};
        boolean b = new CanJump().canJump(res);
        System.out.println(b);

    }
}
