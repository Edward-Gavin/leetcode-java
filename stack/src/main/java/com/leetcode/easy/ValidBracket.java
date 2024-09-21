package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shiwei10
 * @Date: 2024/4/23 17:21
 */
public class ValidBracket {
    public static boolean isValidBracket(String s) {

        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Stack<Character> tempStack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>(3) {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (hashMap.containsKey(value)) {
                if (tempStack.empty() || (!tempStack.peek().equals(hashMap.get(value)))) {
                    return false;
                }
                tempStack.pop();
            } else {
                tempStack.push(value);
            }
        }

        return tempStack.empty();
    }

    public static void main(String[] args) {
        String s = "([}}])";
        boolean validBracket = isValidBracket(s);
        System.out.println(validBracket);
    }
}
