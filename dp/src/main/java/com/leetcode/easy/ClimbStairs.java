package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/29 15:23
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        return dfs(n);
    }

    public int dfs(int n) {

        // n==1 return 1; n==0 return 1;
        if (n <= 1) {
            return 1;
        }

        return dfs(n - 1) + dfs(n - 2);
    }


    public int climbStairsV2(int n) {

        if (n <= 1) {
            return 1;
        }
        int i0 = 1, i1 = 1;
        int cur;

        for (int i = 2; i <= n; i++) {
            cur = i0;
            i0 = i1;
            i1 = i0 + cur;
        }
        return i1;
    }
}
