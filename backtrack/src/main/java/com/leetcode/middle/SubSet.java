package com.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 10:27
 */
public class SubSet {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> subSet(int[] nums) {

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
}
