package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @author: shiwei10
 * @create: 2024-10-13 21:26
 * @description: 110. 平衡二叉树
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int dfs = dfs(root);
        return dfs != -1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        if (left == -1) {
            return -1;
        }

        int right = dfs(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(right, left) + 1;

    }
}
