package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 18:04
 * @Description: 104. 二叉树最大深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //  左子树最大深度
            int left = maxDepth(root.left);
            // 右子树最大深度
            int right = maxDepth(root.right);
            // 最大深度 +1
            return Math.max(left, right) + 1;
        }
    }
}
