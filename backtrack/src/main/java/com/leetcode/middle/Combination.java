package com.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-09-16 22:45
 * @Description: 组合数
 */
public class Combination {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        List<List<Integer>> combine = combination.combine(5, 3);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer.toString());
            }
            System.out.println();
        }
    }
}
