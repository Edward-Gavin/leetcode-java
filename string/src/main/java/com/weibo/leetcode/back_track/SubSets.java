package com.weibo.leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/29 17:09
 */
public class SubSets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    public void backTrack(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubSets().subsets(new int[]{1, 2, 3}));
    }
}
