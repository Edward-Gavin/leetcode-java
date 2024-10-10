package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * 使用队列存储当前层的节点，然后依次遍历，将下一层的节点加入到队列中
     * @param root 根
     * @return 按层返回的二维list
     */
    public List<List<Integer>> levelOrderV2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
