package com.leetcode.middle;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 15:28
 * @Description: 560. 和为k的子数组
 */
public class SubArraySum {


    // 暴力 超时 时间复杂度 O(n^3)
    public int subarraySum(int[] nums, int m) {

        int len = nums.length;
        int res = 0;

        // 左边界
        for (int i = 0; i < len; i++) {

            // 右边界
            for (int j = i; j < len; j++) {
                int sum = 0;

                // 遍历左右边界中间的数
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == m) {
                    res++;
                }
            }
        }
        return res;
    }

    // 优化 O(N^2)
    public int subarraySumV2(int[] nums, int m) {

        int len = nums.length;
        int res = 0;

        // 左边界
        for (int i = 0; i < len; i++) {
            int sum = 0;
            // 右边界
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == m) {
                    res++;
                }
            }
        }

        return res;
    }

    // 前缀和数组
    public int subarraySumV3(int[] nums, int m) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        int res = 0;

        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == m) {
                    res ++;
                }
            }
        }

        return res;
    }


    // 前缀和 + 哈希表
    public int subarraySumV4(int[] nums, int m) {

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int res = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - m)) {
                res += preSum.get(sum - m);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }

        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        int i = new SubArraySum().subarraySumV4(nums, k);
        System.out.println(i);
    }
}
