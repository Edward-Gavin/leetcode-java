package com.leetcode.review;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/10/14 14:36
 */
public class BinaryTreePaths {

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> getBinaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return paths;
    }

    public void dfs(TreeNode node, List<Integer> path) {

        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path);
            dfs(node.right, path);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3,node6, node7);
        TreeNode node2 = new TreeNode(2,node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        List<List<Integer>> strings = new BinaryTreePaths().getBinaryTreePaths(root);
        System.out.println(strings);
    }
}
