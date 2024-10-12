package com.leetcode.review;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: shiwei10
 * @Date: 2024/10/12 16:04
 */
public class KthSmallest {

    // 中序遍历二叉搜索树，从小到大有序，求最小值，在遍历过程中获取
    public int kthSmallest(TreeNode root, int k) {

        int res = 0;

        if (root == null) {
            return res;
        }

        ArrayList<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            order.add(cur.val);
            order.remove(order.size() - 1);
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }

        return -1;
    }
}
