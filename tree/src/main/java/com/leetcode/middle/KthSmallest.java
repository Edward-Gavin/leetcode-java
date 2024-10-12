package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: shiwei10
 * @create: 2024-09-28 20:34
 * @Description: 230. 二叉搜索树中第 K 小的元素
 */
public class KthSmallest {

    int ans = 0;
    int cnt = 0;


    /**
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);

        return ans;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            ans = node.val;
            return;
        }

        inOrder(node.right, k);
    }

    /**
     * 二叉搜索树，中序遍历是有序的，在遍历的过程中返回即可
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestV2(TreeNode root, int k) {

        ArrayList<TreeNode> list = new ArrayList<>();

        TreeNode temp = root;


        while (temp != null || !list.isEmpty()) {
            while (temp != null) {
                list.add(root);
                temp = temp.left;
            }

            temp = list.remove(list.size() - 1);
            k--;
            if (k == 0) {
                return temp.val;
            }
            temp = temp.right;
        }


        return -1;
    }

    /**
     * 层次遍历 + 堆
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestV3(TreeNode root, int k) {

        int res = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Queue<TreeNode> dq = new LinkedList<>();

        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                queue.add(node.val);

                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }

            }
        }

        while (!queue.isEmpty() && k > 0) {
            res = queue.poll();
            k--;
        }

        return res;
    }
}
