package com.leetcode.middle;

import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/23 10:50
 * @Description: 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.peek();
    }

    public int findKthLargestV2(int[] nums, int k) {


        return 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(input, 3);
        System.out.println(kthLargest);
    }


}
