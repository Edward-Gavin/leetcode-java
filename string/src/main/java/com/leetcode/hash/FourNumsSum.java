package com.leetcode.hash;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/4/23 11:19
 */
public class FourNumsSum {
    public static int fourNumsSum(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer, Integer> sumAB = new HashMap<>();
        int result = 0;

        for (int i : a) {
            for (int j : b) {
                int key = i + j;
                sumAB.put(key, sumAB.getOrDefault(key, 0) + 1);
            }
        }

        for (int k : c) {
            for (int l : d) {
                if (sumAB.containsKey(-k - l)) {
                    result+=sumAB.get(-k - l);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
