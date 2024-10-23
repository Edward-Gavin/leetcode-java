package com.leetcode.hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 20:00
 * @Description: 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    // 暴力法
    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int[] res = new int[length + 1 - k];

        int left = 0, right = k - 1;

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

    // 双向队列
    public int[] maxSlidingWindowV2(int[] nums, int k) {

        LinkedList<Integer> queue = new LinkedList<>();

        int len = nums.length;
        int[] res = new int[len + 1 - k];

        for (int i = 0; i < len; i++) {

            // 如果队列中的数比新来的数小，依次弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.add(i);

            // 队列里存储的数，大于窗口大小，弹出
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            // 保存当前窗口最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }

        return res;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowV3(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length + 1 - k];


        // 形成窗口
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }

        res[0] = queue.peekFirst();


        // 窗口内操作
        for (int i = k; i < nums.length; i++) {
            // 删除窗口左边的元素
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }

            // 保持队列中的元素last最大
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }

            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new MaxSlidingWindow().maxSlidingWindowV2(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
