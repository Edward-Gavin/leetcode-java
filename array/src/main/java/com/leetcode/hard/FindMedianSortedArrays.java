package com.leetcode.hard;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 10:20
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] ints = mergeTwoArray(nums1, nums2);

        int length = ints.length;
        int i = 0;
        int j = length - 1;

        while (i <= j) {
            if (i == j) {
                return ints[i];
            }
            if (i + 1 == j) {
                return (double) (ints[i] + ints[j]) / 2;
            }
            i++;
            j--;
        }

        return 0.0;

    }

    public int[] mergeTwoArray(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0) {
            return nums2;
        }

        if (length2 == 0) {
            return nums1;
        }

        int[] res = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                res[index] = nums1[i];
                i++;
            } else {
                res[index] = nums2[j];
                j++;
            }
            index++;
        }

        while (j < length2) {
            res[index] = nums2[j];
            index++;
            j++;
        }

        while (i < length1) {
            res[index] = nums1[i];
            index++;
            i++;
        }

        return res;
    }
}
