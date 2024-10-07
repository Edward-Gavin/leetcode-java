package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 19:09
 */
public class CoinChange {

    int res = Integer.MAX_VALUE;

    List<List<Integer>> all = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int[] memory;

    public static void main(String[] args) {
        int[] coins = {1, 2};
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChangeV2(coins, 4);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {

        int length = coins.length;

        if (length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        System.out.println(all);
        return res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
            all.add(new ArrayList<>(path));
            return;
        }

        for (int coin : coins) {
            path.add(coin);
            findWay(coins, amount - coin, count + 1);
            path.removeLast();
        }
    }

    public int coinChangeV2(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }

        memory = new int[amount];

        return find(coins, amount);
    }

    public int find(int[] coins, int amount) {


        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memory[amount - 1] != 0) {
            return memory[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = find(coins, amount - coins[i]);
            if (res > 0 && res < min) {
                min = res + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            memory[amount - 1] = -1;
        } else {
            memory[amount - 1] = min;
        }
        return memory[amount - 1];
    }

    public int coinChangeV3(int[] coins, int amount) {


        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) {
            res.add(new ArrayList<>(path));
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                path.add(coin);
            }
        }
        System.out.println(res);

        if (dp[amount] != 10001) {
            return dp[amount];
        } else {
            return -1;
        }
    }
}
