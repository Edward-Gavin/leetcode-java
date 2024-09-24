package com.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 11:17
 */
public class MedianFinder {
    private PriorityQueue<Integer> queMin;
    private PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queMax = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {

        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMax.peek() + queMin.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
