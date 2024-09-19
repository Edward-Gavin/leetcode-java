package com.leetcode.middle;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/4/23 11:19
 * @Description: 454. 四数相加II
 */
public class FourNumsSum {
    public static int fourNumsSum(int[] a, int[] b, int[] c, int[] d) {

        // 跟两数之和类似，将前两个数组的数加和，并存储在hash里，key是加和结果，value 是出现的次数
        // 然后加和后两个数组，遍历，在hash里找到加和，结果+加和出现的次数
        HashMap<Integer, Integer> sumAB = new HashMap<>();
        int result = 0;

        // 前两个数组加和的结果，存储在hash中
        for (int i : a) {
            for (int j : b) {
                int key = i + j;
                sumAB.put(key, sumAB.getOrDefault(key, 0) + 1);
            }
        }

        // 后两个数组加和的结果，在hash中寻找，
        for (int k : c) {
            for (int l : d) {
                if (sumAB.containsKey(-k - l)) {
                    result += sumAB.get(-k - l);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
