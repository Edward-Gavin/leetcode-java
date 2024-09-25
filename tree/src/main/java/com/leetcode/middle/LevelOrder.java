package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/5/30 19:37
 */
public class LevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        TreeNode[] queue = new TreeNode[2001];

        int left = 0;
        int right = 0;

        if (root != null) {
            queue[right++] = root;
            while (left < right) {
                int size = right - left;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[left];
                    left++;
                    list.add(cur.val);

                    if (cur.left != null) {
                        queue[right] = cur.left;
                        right++;
                    }

                    if (cur.right != null) {
                        queue[right] = cur.right;
                        right++;
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
}
