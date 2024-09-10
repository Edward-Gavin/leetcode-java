package com.weibo.leetcode.hash;

/**
 * @Author: shiwei10
 * @Date: 2024/4/25 10:23
 * @Description: 383
 */
public class ArrayInclude {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int temp =  ransomNote.charAt(i) - 'a';
            hash[temp] -= 1;
            if (hash[temp] < 0) {
                return false;
            }
        }
        return true;
    }
}
