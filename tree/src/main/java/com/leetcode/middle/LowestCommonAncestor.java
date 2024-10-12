package com.leetcode.middle;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @Author: shiwei10
 * @Date: 2024/10/12 16:59
 * @Description:
 */
public class LowestCommonAncestor {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root);

        // 依次找到p，p的所有父节点，并加入到访问的表中
        while (p != null) {
            // 加入p自己，因为可能p是q的父节点
            visited.add(p.val);
            p = parent.get(p.val);
        }

        // 依次找到q，q的所有父节点，查看是否访问过，访问过说明存在公共的祖先
        while (q != null) {

            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return null;
    }

    // 遍历将所有的节点的的父节点加到map中，<child.val, parent>
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
