package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-09-21 17:51
 * @Description: 881 救生艇
 */
public class NumRescueBoat {



    public static int numRescueBoat(int[] nums, int limit) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int res = 0;

        while (left <= right) {
            int weight = nums[left] + nums[right];
            if (weight <= limit) {
                left++;
            }
            right--;
            res++;
        }

        return res;
    }


    public static void splitOddEven(int[] nums) {

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        int[] oddArray = listToArray(odd);
        int[] evenArray = listToArray(even);

    }

    public static int[] listToArray(List list) {

        int size = list.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = list.indexOf(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,2};
        int temp = numRescueBoat(ints,3);
        System.out.println(temp);
    }
}
