package com.leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Create: 2024-10-22 21:55
 * @Description:
 */
public class FourNumSum {
    public static int fourNumsSum(int[] a, int[] b, int[] c, int[] d) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                map.put(i + j, map.getOrDefault(-i - j, 0) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (map.containsKey(i + j)) {
                    res += map.get(i + j);
                }
            }
        }

        return res;
    }
}

