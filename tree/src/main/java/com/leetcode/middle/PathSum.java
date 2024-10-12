package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Date: 2024/10/12 16:42
 * @Description: 437. 路径总和 III
 */
public class PathSum {

    Map<Long, Integer> prefixMap = new HashMap<>();
    int sum;

    public int pathSum(TreeNode root, int target) {
        sum = target;
        prefixMap.put(0L, 1);
        return dfs(root, 0);
    }


    public int dfs(TreeNode node, long curSum) {

        if (node == null) {
            return 0;
        }

        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - sum, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        int left = dfs(node.left, curSum);
        int right = dfs(node.right, curSum);

        res = res + left + right;

        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }
}
