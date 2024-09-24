package com.leetcode.easy;

/**
 * @Author: shiwei10
 * @Date: 2024/9/23 18:49
 */
public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int[] array) {


    }

    public static void minHeap(int[] array, int index) {



    }

    public static void insert(int[] array, int size, int index) {

    }

    public static void heapify(int[] array, int index, int size) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int biggest = index;

        if (left < size && array[left] > array[biggest]) {
            biggest = left;
        }
        if (right < size && array[right] > array[biggest]) {
            biggest = right;
        }

        if (biggest != index) {
            swap(array, index, biggest);
            heapify(array, biggest, size);
        }

    }

    public static void heapSort(int[] array) {


    }




    public static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
}
