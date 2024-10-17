package com.leetcode.one.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Date: 2024/10/17 19:12
 * @Description: 139. 单词拆分
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Boolean> map = new HashMap<>();

        for (String string : wordDict) {
            map.put(string, true);
        }

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && map.getOrDefault(s.substring(j, i), false);
                if (dp[i]) {
                    break;
                }
             }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepencode";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("code");

        boolean b = new WordBreak().wordBreak(s, list);
        System.out.println(b);

    }
}
