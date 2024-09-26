package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/26 16:26
 * @Description: 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        // 根据升序数组，恢复高度平衡的BST
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        // 中间节点，移位优先级比+优先级小
        int mid = start + ((end - start) >> 1);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {

        int start = 0;
        int end = 10;
        int mid = start + (end - start) / 2;
        int mid2 = start + (end - start) >> 1;
    }
}
