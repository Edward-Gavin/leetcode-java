package com.leetcode.easy;


/**
 * @Author: shiwei10
 * @Date: 2024/9/27 19:19
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }

        return single;
    }

    public static void main(String[] args) {

        int[] input = {2, 2, 1, 1, 1, 2, 2};

        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber(input);
        System.out.println(i);
    }
}
