package com.leetcode.review;

import java.util.Stack;

/**
 * @Author: shiwei10
 * @Date: 2024/10/23 19:11
 */
public class DailyTemperature {
    public int[] dailyTem(int[] tem) {

        int length = tem.length;
        int[] res = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && tem[i] > tem[stack.peek()]) {
                Integer peek = stack.peek();
                Integer pop = stack.pop();
                res[pop] = i - peek;
            }
            stack.push(i);
        }

        return res;
    }
}
