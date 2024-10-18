package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-10-08 22:37
 * @description: 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    /**
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            int total = 1;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    total *= nums[j];
                }
            }
            res[i] = total;
        }
        return res;
    }

    /**
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelfV2(int[] nums) {

        int length = nums.length;
        int[] res = new int[length];

        int[] pre = new int[length];

        int[] post = new int[length];

        pre[0] = 1;
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        post[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            res[i] = pre[i] * post[i];
        }

        return res;
    }

    public int[] productExceptSelfV3(int[] nums) {

        int length = nums.length;

        int[] res = new int[length];

        int[] lr = new int[length];
        int[] rl = new int[length];

        lr[0] = 1;
        rl[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            lr[i] = lr[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            rl[i] = rl[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            res[i] = lr[i] * rl[i];
        }

        return res;
    }

    public static void main(String[] args){

        int[] input = new int[]{1,2,3,4};
        int[] ints = new ProductExceptSelf().productExceptSelfV3(input);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
