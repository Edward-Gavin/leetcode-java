package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/5/7 19:51
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        long a = Long.MAX_VALUE;
        double pow = Math.pow(2, 44);
        long v = a / (long) pow;
        System.out.println(v);
    }
}

