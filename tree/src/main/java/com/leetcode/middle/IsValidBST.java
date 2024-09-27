package com.leetcode.middle;

import com.leetcode.TreeNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/26 19:01
 */
public class IsValidBST {

    Integer pre = Integer.MIN_VALUE;


    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        }

        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val < pre) {
            return true;
        }

        pre = root.val;

        return isValidBST(root.right);
    }
}
