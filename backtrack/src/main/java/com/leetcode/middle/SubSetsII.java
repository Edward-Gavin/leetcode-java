package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 11:29
 */
public class SubSetsII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> subSetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backTrack(nums, 0);

        return res;
    }

    public void backTrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }
}
