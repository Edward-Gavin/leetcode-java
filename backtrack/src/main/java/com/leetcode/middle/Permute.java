package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-09-17 21:00
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {

        int length = nums.length;


        if (length == 0) {
            return res;
        }

        boolean[] used = new boolean[length];

        backTrack(nums, length, 0, used);


        return res;
    }


    public void backTrack(int[] nums, int len, int depth, boolean[] used) {
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                backTrack(nums, len, depth + 1, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}
