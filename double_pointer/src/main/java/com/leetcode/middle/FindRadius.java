package com.leetcode.middle;

import java.util.Arrays;

/**
 * @author: shiwei10
 * @create: 2024-09-21 18:41
 * @Description: 475. 供暖器
 */
public class FindRadius {
    public static int findRadius(int[] houses, int[] heaters) {

        int res = 0;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        for (int i = 0, j = 0; i < houses.length; i++) {
            int distance = Math.abs(houses[i] - heaters[j]);

            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                distance = Math.min(distance, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(res, distance);
        }

        return res;
    }
}
