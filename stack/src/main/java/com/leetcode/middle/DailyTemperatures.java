package com.leetcode.middle;

import java.util.Stack;

/**
 * @author: shiwei10
 * @create: 2024-09-22 12:01
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        int[] res = new int[length];

        if (length == 1) {
            return new int[]{0};
        }

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length && temperatures[j] <= temperatures[i]) {
                j++;
            }

            if (j == length) {
                res[i] = 0;
            } else if (temperatures[j] >= temperatures[i]) {
                res[i] = j - i;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }


    public static int[] dailyTemperaturesStack(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];

        if (length == 1) {
            return new int[]{0};
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] <= temperatures[i]) {
                stack.push(i);
            } else {
                int temp = i;
                Integer max = stack.pop();
                int index = 1;
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    res[temp - index - 1] = max - pop;
                    max = pop;
                    index ++;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] input2 = new int[]{30, 40, 50, 60};
        int[] ints = dailyTemperaturesStack(input);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
