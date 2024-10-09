package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/18 17:40
 */
public class Anagram {



    public boolean isAnagram(String s, String t) {

        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength) {
            return false;
        }

        int[] mapCount = new int[26];

        for (int i = 0; i < sLength; i++) {
            mapCount[s.charAt(i) - 'a'] += 1;
            mapCount[t.charAt(i) - 'a'] -= 1;
        }

        for (int i : mapCount) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "avb";
        System.out.println(s.charAt(0));
    }
}
