package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 20:01
 * @Description: 121. 买卖股票的最佳时机
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {

        int maxPro = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int price : prices) {
            minVal = Math.min(minVal, price);

            if (price - minVal > maxPro) {
                maxPro = price - minVal;
            }

        }

        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new MaxProfit().maxProfit(prices);
        System.out.println(i);
    }
}
