package com.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/4/29 20:19
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}));
    }
}
