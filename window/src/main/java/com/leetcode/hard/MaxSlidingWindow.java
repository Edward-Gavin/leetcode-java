package com.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 20:00
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int[] res = new int[length + 1 - k];

        int left = 0, right = k-1;

        while (right < length) {
            res[left] = maxNumberWindow(nums, left, right);
            left++;
            right++;
        }

        return res;
    }

    public int maxNumberWindow(int[] nums, int left, int right) {

        int res = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            res = Math.max(res, nums[i]);
        }

        return res;
    }

    public int[] maxSlidingWindowV1(int[] nums, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        int[] res = new int[nums.length + 1 - k];

        res[0] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] < i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }

        return res;
    }

        public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new MaxSlidingWindow().maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);

        }

    }
}
