package com.leetcode.middle;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 10:15
 */
public class TopKFrequent {
    static class Pair {
        private int key;
        private int value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            queue.add(new Pair(i, map.get(i)));
        }

        for (int i = k; i > 0; i--) {
            res[i - 1] = queue.poll().key;
        }

        return res;
    }
}
