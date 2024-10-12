package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.*;

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
     * 迭代法
     *
     * @param root
     * @param res
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // 处理结果
            res.add(node.val);

            // 先压入右孩子
            if (node.right != null) {
                stack.add(node.right);
            }

            // 压入左孩子，保证先弹出左孩子
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
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

    public List<Integer> postOrder(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        while (!stack1.isEmpty()) {

            TreeNode node = stack1.pop();
            stack2.push(node);

            // 压栈的时候，保证根节点先进栈，左右为一个整体进栈，弹出一起弹出
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;
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

    public List<Integer> inOrder(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    /**
     * 层次遍历 dfs
     *
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

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> depthOrder(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            res.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
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
