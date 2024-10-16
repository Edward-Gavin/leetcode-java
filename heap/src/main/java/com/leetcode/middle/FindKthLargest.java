package com.leetcode.middle;

import java.util.*;

/**
 * @Author: shiwei10
 * @Date: 2024/9/23 10:50
 * @Description: 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int num : nums) {
            buckets[num + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    public static int findKthLargestV3(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.peek();
    }

    public static int findKthLargestV2(List<Integer> nums, int k) {
        // 快排思想
        Random random = new Random();
        int cur = nums.get(random.nextInt(nums.size()));

        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();

        for (int num : nums) {
            if (num > cur) {
                big.add(num);
            } else if (num < cur) {
                small.add(num);
            }
        }

        if (k <= big.size()) {
            return findKthLargestV2(big, k);
        }

        if (nums.size() - small.size() < k) {
            return findKthLargestV2(small, k - nums.size() + small.size());
        }

        return cur;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        FindKthLargest findKthLargest = new FindKthLargest();
        int i = findKthLargest.findKthLargest(input, 3);
        System.out.println(i);
    }
}
