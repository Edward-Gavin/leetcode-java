package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: shiwei10
 * @create: 2024-10-13 20:20
 * @description:
 */
public class MinDepth {

    public int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepthDfs(root.left);
        int right = minDepthDfs(root.right);

        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    /**
     * 层次遍历求最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int res = 0;

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res++;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }

                // 左右都为空的时候，才是最小深度   [2,null,3,null,4,null,5,null,6]
                if (poll.left == null && poll.right == null) {
                    return res;
                }
            }

            res++;
        }
        return res;
    }
}
