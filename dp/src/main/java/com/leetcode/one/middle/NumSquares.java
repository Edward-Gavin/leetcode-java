package com.leetcode.one.middle;

import java.util.HashMap;

/**
 * @Author: shiwei10
 * @Date: 2024/10/16 16:14
 */
public class NumSquares {
    public int numSquares(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return dfs(n, map);
    }

    public int dfs(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, dfs(n - i * i, map) + 1);
        }

        map.put(n, count);

        return count;
    }
}
