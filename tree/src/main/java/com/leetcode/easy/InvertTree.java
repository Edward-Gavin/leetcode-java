package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 20:12
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
