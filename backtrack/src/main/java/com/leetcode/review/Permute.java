package com.leetcode.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/12/6 20:19
 */
public class Permute {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums){
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int first){
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
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
        int[] input = new int[]{1, 2, 3, 4};
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(input);
        System.out.println(permute1);
    }
}
