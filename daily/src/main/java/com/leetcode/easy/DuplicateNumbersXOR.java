package com.leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: shiwei10
 * @Date: 2024/10/12 11:24
 * @Description: 3158. 求出出现两次数字的 XOR 值
 */
public class DuplicateNumbersXOR {
    public int duplicationNumberXOR(int[] nums) {

        int res = 0;
        Set<Integer> set = new TreeSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                res ^= num;
            } else {
                set.add(num);
            }
        }

        return res;
    }

    // 如何用位（一个整数）存储一个集合
    public void numberToBit() {
        int[] nums = {0, 2, 3};
        double a = 0;

        for (int j : nums) {
            a += Math.pow(2, j);
        }
        System.out.println(a);
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3};
        int[] nums2 = {1, 2, 3};
        DuplicateNumbersXOR duplicateNumbersXOR = new DuplicateNumbersXOR();
        int i = duplicateNumbersXOR.duplicationNumberXOR(nums2);
        System.out.println(i);

        duplicateNumbersXOR.numberToBit();

    }
}
