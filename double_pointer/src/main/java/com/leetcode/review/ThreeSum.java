package com.leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/10/22 19:43
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        Arrays.sort(nums);


        // 第一个数
        for (int i = 0; i < length; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    right--;
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeSum().threeSum(input);
        System.out.println(lists);

    }
}
