package com.leetcode.easy;

import com.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 20:12
 * @Description: 226. 翻转二叉树
 */
public class InvertTree {
    /**
     * 后序遍历，翻转二叉树
     * @param root
     * @return
     */
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

    /**
     * 层次遍历，并翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTreeLevel(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                swapNode(poll);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }

        return root;
    }

    public void swapNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
