package com.leetcode.middle;

import java.nio.file.Path;
import java.util.ArrayList;
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
            return ;
        }
        if (amount == 0) {
            res = Math.min(res, count);
            all.add(new ArrayList<>(path));
            return ;
        }

        for (int coin : coins) {
            path.add(coin);
            findWay(coins, amount - coin, count + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] coins = {1, 2};
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(coins, 4);
        System.out.println(i);
    }
}
