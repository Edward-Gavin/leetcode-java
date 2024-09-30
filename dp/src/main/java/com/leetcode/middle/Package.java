package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/30 14:36
 */
public class Package {
    public static void main(String[] args) {

        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int pack = 4;

        int i = new Package().packageV2(weight, value, pack);

    }


    public int packageV2(int[] weight, int[] value, int pack) {

        int[] dp = new int[pack + 1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = pack; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[pack]);

        return dp[pack];
    }

    public int packageV1(int[] weight, int[] value, int pack){

        int[][] dp = new int[weight.length][pack + 1];

        // 初始化 dp 数组
        for (int i = weight[0]; i <= pack; i++) {
            dp[0][i] = value[0];
        }

        // 构建dp数组，动态规划
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < pack + 1; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        int res = dp[weight.length - 1][pack];
        System.out.println(res);
        return res;
    }
}
