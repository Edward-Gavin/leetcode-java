package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 14:00
 * @Description: 18 四数之和
 */
public class FourSum {
    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};
        List<List<Integer>> lists = new FourSum().fourSum(input, -1000000000);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) (nums[i] + nums[i + 1]) + (long) (nums[i + 2] + nums[i + 3]) > target) {
                break;
            }
            if ((long) (nums[i] + nums[length - 3]) + (long) (nums[length - 2] + nums[length - 1]) < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) (nums[i] + nums[j]) + (long) (nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }
                if ((long) (nums[i] + nums[j]) + (long) (nums[length - 2] + nums[length - 1]) < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[left]);
                        integers.add(nums[right]);
                        res.add(integers);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
