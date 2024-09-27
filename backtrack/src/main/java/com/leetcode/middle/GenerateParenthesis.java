package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 14:10
 * @Description: 22. 括号生成
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backTrack(new char[n * 2], 0);

        return res;
    }

    public void backTrack(char[] chars, int position) {
        if (chars.length == position) {
            if (isValid(chars)) {
                res.add(new String(chars));
            }
        } else {
            chars[position] = '(';
            backTrack(chars, position + 1);
            chars[position] = ')';
            backTrack(chars, position + 1);
        }
    }

    public boolean isValid(char[] chars) {

        int count = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;

    }

 }
