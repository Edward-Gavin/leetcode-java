package com.leetcode.tree;

import java.util.LinkedList;

/**
 * @Author: shiwei10
 * @Date: 2024/5/7 19:22
 */
public class Traversal {
    public static void preorderTraversal(TreeNode root, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    public static void postorderTraversal(TreeNode root, LinkedList<Integer> result){
        if (root == null) {
            return ;
        }

        postorderTraversal(root.left, result);
        result.add(root.val);
        postorderTraversal(root.right, result);
    }

    public static void main(String[] args) {
        LinkedList<Integer> result = new LinkedList<>();
        TreeNode root = new TreeNode();
        preorderTraversal(root, result);
        System.out.println(result);
    }
}
