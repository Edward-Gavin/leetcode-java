package com.leetcode.back_track;

import java.util.*;

/**
 * @Author: shiwei10
 * @Date: 2024/4/25 19:44
 * @Description: 083
 */
class Permute {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int first) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtrack(nums, i + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3, 4}));
        Map<String, String> map = new HashMap<>();
    }
}