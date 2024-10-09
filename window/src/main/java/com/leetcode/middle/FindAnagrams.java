package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 14:42
 * @Description: 438. 找到字符串中所有字母异位次
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<>();

        int pl = p.length();
        int sl = s.length();

        int left = 0;
        int right = pl;

        while (right <= sl) {
            String substring = s.substring(left, right);
            if (isAnagrams(substring, p)) {
                res.add(left);
            }
            left++;
            right++;
        }

        return res;
    }

    public boolean isAnagrams(String s, String p) {

        int sl = s.length();
        int pl = p.length();

        if (sl != pl) {
            return false;
        }

        int[] temp = new int[26];

        for (int i = 0; i < sl; i++) {
            temp[s.charAt(i) - 'a'] += 1;
            temp[p.charAt(i) - 'a'] -= 1;
        }

        for (int i : temp) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagrams = new FindAnagrams().findAnagrams(s, p);
        System.out.println(anagrams);

    }
}
