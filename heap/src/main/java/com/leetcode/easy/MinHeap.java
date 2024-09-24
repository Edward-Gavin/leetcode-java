package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/23 18:49
 */
public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int[] array) {
        heap = array;
        size = array.length;
        build();
    }

    public void build() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(heap, i, size);
        }
    }

    public static void heapify(int[] array, int index, int size) {

        int min = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }

        if (min != index) {
            swap(array, index, min);
            heapify(array, min, size);
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 9, 7, 6, 4, 11, 2, 10, 8};
        MinHeap minHeap = new MinHeap(array);
        System.out.println(minHeap);

        int parent = (4 - 1) >>> 1;
    }
}
