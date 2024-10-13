package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 20:17
 * @Description: 101. 对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        // return check(root, root);

        return compare(root.left, root.right);
    }

    /**
     * 递归法
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 需要收集孩子的信息题目，需要后序遍历，因为遍历顺序是 左右中，最后遍历父节点可以收集左右孩子的信息
     *
     * @param left
     * @param right
     * @return boolean
     */
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        boolean compare = compare(left.left, right.right);
        boolean compare1 = compare(left.right, right.left);
        return compare && compare1;
    }
}
