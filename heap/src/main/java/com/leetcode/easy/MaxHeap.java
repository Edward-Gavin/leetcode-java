package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/24 14:28
 */
public class MaxHeap {

    private int[] heap;
    private int size;


    public MaxHeap(int[] array) {
        heap = array;
        size = array.length;
        build();
    }

    private void build() {
        int lastParent = size / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[max]) {
            max = left;
        }

        if (right < size && heap[right] > heap[max]) {
            max = right;
        }

        if (max != i) {
            swap(heap, max, i);
            heapify(max);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void insert(int element){
        heap[size] = element;
        size++;

        int index = size - 1;

        while (index > 0 && heap[index] > heap[index / 2]) {
            swap(heap, index, index / 2);
            index = index / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 9, 7, 6, 4, 11, 2, 10, 8};
        MaxHeap maxHeap = new MaxHeap(array);

    }
}
