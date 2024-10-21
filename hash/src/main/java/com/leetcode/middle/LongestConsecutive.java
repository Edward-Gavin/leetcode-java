package com.leetcode.middle;

import java.util.HashSet;

/**
 * @Author: shiwei10
 * @Date: 2024/9/18 19:12
 * @Description: 128. 最长连续序列
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {

        // 去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        int length;
        for (Integer i : set) {
            int cur = i;
            // 不包含前一个数字
            if (!set.contains(cur - 1)) {
                // 算上当前这个数字
                length = 1;
                
                // 依次向后遍历，判断是否连续
                while (set.contains(cur + 1)) {
                    cur++;
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}
