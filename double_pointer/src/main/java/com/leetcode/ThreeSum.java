package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 11:39
 * @Description: 三数之和
 */
public class ThreeSum {

    /**
     * @param nums the input array
     * @return return collection of result list.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;


        // 固定一个数，依次双指针来遍历其他的数字
        for (int i = 0; i < length; i++) {

            // 三个数之和为0，如果排序后的第一个数大于0，那么和肯定大于0，且以后的数据都不用判断了
            if (nums[i] > 0) {
                return res;
            }

            // 去重第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    res.add(integers);

                    // 去重左侧的数
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 去重右侧的数
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    /**
     * @param args main
     */
    public static void main(String[] args) {
        final int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ThreeSum.threeSum(input);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
