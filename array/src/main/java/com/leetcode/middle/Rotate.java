package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-10-08 22:04
 */
public class Rotate {
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        if (k >= len) {
            k = k % len;
        }

        while (k > 0) {

            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;

            k--;
        }
    }

    public void rotateV2(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
    }

    public void rotateV3(int[] nums, int k) {

        int length = nums.length;

        if (k > length) {
            k = k % length;
        }

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);

    }

    public void reverse(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
