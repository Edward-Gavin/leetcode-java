package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shiwei10
 * @Date: 2024/10/14 14:52
 */
public class FindBottomLeftValue {
    /**
     * 层底遍历找到最后一行，找到最左边的节点
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {

        int res = -1;
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
