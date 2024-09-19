package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/27 16:09
 */
public class CombineSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    public void backTracking(int targetSum, int k, int startIndex, int sum) {
        if (targetSum < sum) {
            return ;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
                return ;
            }
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, 0);
        return result;
    }

    public void backTrack(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backTrack2(candidates, target, 0, 0);
        return result;
    }

    public void backTrack2(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack2(candidates, target, sum, i+1);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        // System.out.println(new CombineSum().combinationSum3(3, 7));
        // System.out.println(new CombineSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombineSum().combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}
