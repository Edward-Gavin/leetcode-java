package com.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/27 15:49
 */
public class Combine {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrackingV1(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return ;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }


    public void backTrackingV1(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return ;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> combine = new Combine().combine(10, 2);
        System.out.println(combine);
    }
}
