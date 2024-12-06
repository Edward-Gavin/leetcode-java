package com.leetcode.review;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/12/6 17:10
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {

            int temp = target - nums[i];

            if (hash.containsKey(nums[i])) {
                return new int[]{i, hash.get(nums[i])};
            } else {
                hash.put(temp, i);
            }
        }

        return new int[]{};
    }
}
