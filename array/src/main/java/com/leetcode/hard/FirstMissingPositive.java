package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Create: 2024-10-08 23:01
 * @Description: 41. 数组中缺失的第一个正数
 */
public class FirstMissingPositive {
    /**
     * 引入hash表
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @return
     */
    public int firstMissingPositiveV1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return  nums.length + 1;
    }

    /**
     * 原地hash，把数组当作hash表，按序分别找到位置，如果不在位置上，则交换
     * 时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     * @return
     */
    public int firstMissingPositiveV2(int[] nums){
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 因为nums[i]会当作索引使用，因此需要限制nums[i]的范围，（0，len]，保证nums[i]-1在 [0, len-1]
            // 如果 i 位置上的数与 nums[i]-1 位置上的数不同，交换
            while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        int i = new FirstMissingPositive().firstMissingPositiveV2(nums);
    }
}
