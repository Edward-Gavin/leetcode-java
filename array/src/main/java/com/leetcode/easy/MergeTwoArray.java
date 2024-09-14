package com.leetcode.easy;

/**
 * @author: shiwei10
 * @create: 2024-09-14 22:54
 */
public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n){

        int a = m-1;
        int b = n-1;
        int i = nums1.length-1;

        while (a >= 0 && b >= 0) {
            if (nums1[a] > nums2[b]) {
                nums1[i] = nums1[a];
                a = a -1;
            }else {
                nums1[i] = nums2[b];
                b = b-1;
            }
            i = i-1;
        }

        if (a < 0 ) {
            while(i>=0 && b >= 0){
                nums1[i] = nums2[b];
                i = i-1;
                b = b-1;
            }
        }


    }
}
