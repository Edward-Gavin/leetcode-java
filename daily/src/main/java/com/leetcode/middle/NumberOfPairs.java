package com.leetcode.middle;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/10/11 09:49
 * @Description: 3164. 优质对数的总数 II
 */
public class NumberOfPairs {

    /**
     * 引入哈希表，来存储所有的可能的因子，但会超时...
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int numberOfPairsV1(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int j : nums1) {
            if (j % k == 0) {
                int temp = j / k;
                for (int i = 1; i <= temp; i++) {
                    if (temp % i == 0) {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    }
                }
            }
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                res += map.get(i);
            }
        }

        return res;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long res = 0L;

        for (int j : nums1) {
            if (j % k == 0) {
                int temp = j / k;
                for (int i = 1; i <= Math.sqrt(temp); i++) {
                    if (temp % i == 0) {
                        map.put(i, map.getOrDefault(i, 0) + 1);

                        // 需要把另一个因子存入哈希表
                        int other = temp/i;

                        // 不是自己的因子，加入到哈希表
                        if (other != i) {
                            map.put(other, map.getOrDefault(other, 0) + 1);
                        }
                    }
                }
            }
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                res += map.get(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {1, 3, 4};
        int k = 1;

        long l = new NumberOfPairs().numberOfPairs(nums1, nums2, k);

        System.out.println(l);
    }
}
