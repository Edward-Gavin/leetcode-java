package com.leetcode.middle;

import java.util.Stack;

/**
 * @author: shiwei10
 * @create: 2024-09-22 12:01
 * @Description: 739. 每日温度
 */
public class DailyTemperatures {
    /**
     * 暴力解
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 栈
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperaturesStack(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer peek = stack.peek();
                Integer pop = stack.pop();
                res[pop] = i - peek;
            }
            stack.push(i);
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
