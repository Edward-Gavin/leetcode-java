package com.leetcode.hard;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 13:27
 * @Description: 76. 最小覆盖字串
 */
public class MinWindow {
    public String minWindow(String s, String t) {

        char[] sCharArray = s.toCharArray();
        int length = s.length();

        int resLeft = -1;
        int resRight = length;

        int[] cntS = new int[128];
        int[] cntT = new int[128];

        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;

        for (int i = 0; i < length; i++) {
            cntS[sCharArray[i]]++;
            while (isCover(cntT, cntS)) {
                if (i - left < resRight - resLeft) {
                    resLeft = left;
                    resRight = i;
                }
            }
            cntS[sCharArray[left]]--;
            left++;
        }

        if (resLeft < 0) {
            return "";
        } else {
            return s.substring(resLeft, resRight + 1);
        }
    }

    public boolean isCover(int[] s, int[] t) {

        for (int i = 'A'; i < 'Z'; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }

        for (int i = 'a'; i < 'z'; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindowV1(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";

        int len = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) {
                cnt++;
            }

            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }

            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                res = s.substring(j, i + 1);
            }

        }

        return res;
    }
}
