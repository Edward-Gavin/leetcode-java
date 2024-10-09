package com.leetcode.middle;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 14:00
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();

        if (s.isEmpty()) {
            return 0;
        }

        if (len == 1) {
            return 1;
        }

        int res = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        Set<Character> set = new TreeSet<>();

        while (right < len && left < len) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                res = Math.max(res, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
    }
}
