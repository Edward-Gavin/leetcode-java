package com.leetcode.easy;

import com.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 18:04
 * @Description: 104. 二叉树最大深度
 */
public class MaxDepth {
    /**
     * 后序遍历
     * @param root
     * @return
     */
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

    /**
     * 层次遍历，求深度
     * @param root
     * @return
     */
    public int maxDepthOfLevel(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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
            }
            res++;
        }
        return res;
    }
}
