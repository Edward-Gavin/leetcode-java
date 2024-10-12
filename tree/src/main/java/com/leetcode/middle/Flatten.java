package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shiwei10
 * @Date: 2024/10/12 12:57
 */
public class Flatten {

    List<Integer> value = new ArrayList<>();

    /**
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 存储先序序列
        preOrderVal(root);
        // 断开左孩子
        root.left = null;

        // 连接右孩子
        for (int i = 1; i < value.size(); i++) {
            TreeNode treeNode = new TreeNode(value.get(i), null, null);
            root.right = treeNode;
            root = treeNode;
        }
    }

    /**
     * 先序遍历 存储值
     *
     * @param node
     */
    public void preOrderVal(TreeNode node) {
        if (node == null) {
            return;
        }
        value.add(node.val);
        preOrderVal(node.left);
        preOrderVal(node.right);
    }


    List<TreeNode> treeNodesList = new ArrayList<>();

    /**
     * @param root
     */
    public void flattenV2(TreeNode root) {
        if (root == null)
            return;
        preOrderNode(root);
        root.left = null;
        for (int i = 1; i < treeNodesList.size(); i++) {
            TreeNode right = treeNodesList.get(i);
            root.right = right;
            root.left = null;
            root = right;
        }
    }

    /**
     * 先序遍历，存储节点
     *
     * @param node
     */
    public void preOrderNode(TreeNode node) {
        if (node == null) {
            return;
        }
        treeNodesList.add(node);
        preOrderNode(node.left);
        preOrderNode(node.right);
    }


    public void flattenV3(TreeNode root) {
        if (root == null) {
            return ;
        }

        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);
        TreeNode pre = null;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();

            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }

            // 复制中间节点，到栈中
            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (right != null) {
                queue.push(right);
            }
            if (left != null) {
                queue.push(left);
            }
            pre = cur;
        }
    }
}
