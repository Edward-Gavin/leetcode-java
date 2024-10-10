package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: shiwei10
 * @Date: 2024/5/7 19:22
 * @Description: 遍历二叉树
 */
public class Traversal {
    /**
     * 先序遍历
     *
     * @param root
     * @param result
     */
    public static void preorderTraversal(TreeNode root, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param result
     */
    public static void postorderTraversal(TreeNode root, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, result);
        result.add(root.val);
        postorderTraversal(root.right, result);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param result
     */
    public static void inorderTraversal(TreeNode root, LinkedList<Integer> result) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> result = new LinkedList<>();
        TreeNode root = new TreeNode();
        preorderTraversal(root, result);
        System.out.println(result);
    }
}
