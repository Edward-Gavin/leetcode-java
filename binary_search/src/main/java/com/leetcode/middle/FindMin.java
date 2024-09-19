package com.leetcode.middle;

import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 20:13
 */
public class FindMin {
    public int findMin(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
        }

        return queue.peek();
    }
}
