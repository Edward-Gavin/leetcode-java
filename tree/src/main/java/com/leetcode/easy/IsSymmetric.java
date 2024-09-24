package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 20:17
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {

        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val ==q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
