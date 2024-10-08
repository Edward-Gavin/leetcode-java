package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shiwei10
 * @create: 2024-10-08 23:01
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return  nums.length + 1;
    }
}
