package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-09-24 22:56
 */
public class ZigZagOrder {
    public List<List<Integer>> zigZagOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        TreeNode[] queue = new TreeNode[3001];

        int left = 0, right = 0;

        if (root != null) {
            queue[right] = root;
            right++;
            while (left < right) {
                int size = right - left;

            }
        }




        return res;

    }
}
