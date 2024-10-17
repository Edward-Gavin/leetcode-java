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


    public String maxPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int left;
        int right;

        int start = 0;
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;

            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left > longest) {
                start = left ;
                longest = right - left;
            }
        }
        return s.substring(start+1, start + longest);
    }
}
