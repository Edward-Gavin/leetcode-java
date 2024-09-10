package com.weibo.leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/27 17:41
 */
public class LetterCombinations {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        backTrack(digits, 0);
        return result;
    }

    public void backTrack(String dig, int n) {
        if (path.length() == dig.length()) {
            result.add(path.toString());
            return;
        }
        String number = numbers[dig.charAt(n) - '0'];
        for (int j = 0; j < number.length(); j++) {
            path.append(number.charAt(j));
            backTrack(dig, n + 1);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
