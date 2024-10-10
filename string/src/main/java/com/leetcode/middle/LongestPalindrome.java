package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 10:28
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        int left, right;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                left--;
                right++;
            }

            if (right - left > maxLen) {
                maxLen = right - left;
                maxStart = left;
            }

        }

        return s.substring(maxStart + 1, maxStart + maxLen);
    }

    public static void main(String[] args) {
        String s = "aba";
        String s1 = new LongestPalindrome().longestPalindrome(s);
        System.out.println(s1);

    }
}
