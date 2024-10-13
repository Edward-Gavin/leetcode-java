package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @author: shiwei10
 * @create: 2024-10-13 20:51
 * @description: 222. 完全二叉树的节点个数
 */
public class CountNodes {

    public int countNodesV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodesV1(root.left);
        int right = countNodesV1(root.right);
        return left + right + 1;
    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int i = fullTree(root);
        if (i != -1) {
            return 2 << i - 1;
        }

        int i1 = countNodes(root.left);
        int i2 = countNodes(root.right);

        return i1 + i2 + 1;
    }


    /**
     * 判断是否满二叉树
     * @param node
     * @return
     */
    public int fullTree(TreeNode node) {

        TreeNode left = node.left;
        TreeNode right = node.right;

        int lc = 0;
        int rc = 0;

        while (left != null) {
            left = left.left;
            lc++;
        }
        while (right != null) {
            right = right.right;
            rc++;
        }

        return lc == rc ? lc : -1;
    }
}
