package com.leetcode.middle;

import java.util.Stack;

/**
 * @author: shiwei10
 * @create: 2024-09-22 00:18
 * @Description: 394. 字符串解码
 */
public class DecodeString {

    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {

                // 字母
                StringBuilder str = new StringBuilder();
                while (stack.peek() != '[') {
                    str.append(stack.pop());
                }
                String s1 = str.reverse().toString();
                // 左中括号
                stack.pop();

                // 数字
                StringBuilder num = new StringBuilder();
                while (!stack.empty() && stack.peek() >= 48 && stack.peek() <= 57) {
                    num.append(stack.pop());
                }

                // 重复计算当前字符串
                Integer integer = Integer.valueOf(num.reverse().toString());
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer i1 = 0; i1 < integer; i1++) {
                    stringBuilder.append(s1);
                }

                //  如果结束了，返回，否则，加入栈中
                if (stack.isEmpty() && i == num.length() - 1) {
                    return stringBuilder.toString();
                } else {
                    for (int i1 = 0; i1 < stringBuilder.length(); i1++) {
                        stack.push(stringBuilder.charAt(i1));
                    }
                }

            } else {
                stack.push(c);
            }
        }

        // 栈中的数据就是最终的结果，需要遍历弹出
        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String b = "3[a2[c]]";
        String c = "2[abc]3[cd]ef";
        String d = "abc3[cd]xyz";
        String s1 = decodeString(c);
        System.out.println(s1);
    }
}
