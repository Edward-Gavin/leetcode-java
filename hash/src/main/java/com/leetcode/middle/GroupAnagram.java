package com.leetcode.middle;

import java.util.*;

/**
 * @Author: shiwei10
 * @Date: 2024/9/18 17:35
 * @Description: 49. 字母异位词分组
 */
public class GroupAnagram {
    public static boolean isAnagram(String s, String t) {

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

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        int length = strs.length;

        if (length == 0 || length == 1) {
            res.add(Arrays.asList(strs));
            return res;
        }

        for (String str : strs) {
            boolean flag = false;
            for (List<String> re : res) {
                if (!re.isEmpty()) {
                    if (isAnagram(re.get(0), str)) {
                        re.add(str);
                        flag = true;
                    }
                }
            }
            if (!flag) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                res.add(strings);
            }
        }

        Map<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            // 字符串排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if (hash.containsKey(s)) {
                List<String> strings = hash.get(s);
                strings.add(str);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                hash.put(s, strings);
            }
        }
        return new ArrayList<>(hash.values());
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                ArrayList<String> r = new ArrayList<>();
                r.add(str);
                map.put(s, r);
            }
        }
        return new ArrayList<>(map.values());
    }
}

