package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Create: 2024-10-13 22:45
 * @Description: 404.左叶子之和
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int mid = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            mid = node.left.val;
        }

        return left + right + mid;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3,node6, node7);
        TreeNode node2 = new TreeNode(2,node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        int i = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        System.out.println(i);
    }
}
