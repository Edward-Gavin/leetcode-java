package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shiwei10
 * @Date: 2024/4/23 17:21
 */
public class ValidBracket {
    public static boolean isValidBracket(String s) {
        Stack<Character> tempStack = new Stack<>();
        List<Character> charList = Arrays.asList('{', '[', '(');

        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (charList.contains(value)) {
                if (value == '{') {
                    tempStack.push('}');
                } else if (value == '[') {
                    tempStack.push(']');
                } else if (value == '(') {
                    tempStack.push(')');
                }
            } else {


            }
        }


        return true;
    }
}
