package com.leetcode.middle;

import com.leetcode.TreeNode;

/**
 * @author: shiwei10
 * @create: 2024-09-28 20:34
 */
public class KthSmallest {

    int ans = 0;
    int cnt = 0;


    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);

        return ans;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return ;
        }

        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            ans = node.val;
            return;
        }

        inOrder(node.right, k);
    }
}
