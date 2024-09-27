package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 19:33
 */
public class MajorityElementRec {
    public int majorityElement(int[] nums) {

        int length = nums.length;
        int n = length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > n) {
                return i;
            }
        }

        return 0;

    }
}
