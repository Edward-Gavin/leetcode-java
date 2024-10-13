package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-10-13 21:46
 * @description: 257. 二叉树的所有路径
 */
public class BinaryTreePaths {

    List<String> res;
    private List<List<Integer>> list;

    public List<String> binaryTreePathS(TreeNode root) {
        res = new ArrayList<>();

        dfs(root, "");

        return res;
    }

    public void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            res.add(path + node.val);
            return;
        }

        dfs(node.left, path + node.val + "->");
        dfs(node.right, path + node.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        helper(root, new ArrayList<>());
        List<String> res = new ArrayList<>();
        for (List<Integer> tmp : list) {
            StringBuilder sb = new StringBuilder();
            for (Integer a : tmp) {
                sb.append(a).append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            res.add(sb.toString());
        }
        return res;
    }

    /**
     * 采用前序遍历的递归模板，自顶而下。方法中是对list的修改，需要回溯！
     * @param root
     * @param temp
     */
    public void helper(TreeNode root, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        //如果遍历到叶节点，就把此时的temp做一个快照，把快照加入到list中，防止此后对list中的temp进行操作。
        if (root.left == null && root.right == null) {
            // list.add(temp);//这么写是不对的！！
            list.add(new ArrayList<>(temp));
        } else {
            //二叉树的DFS不是不用回溯！如果存在分支污染的情况依然是要回溯的！！！
            helper(root.left, temp);
            helper(root.right, temp);
        }

        // 删除已经走过的叶子节点
        temp.remove(temp.size() - 1);
    }
}
