package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/30 15:41
 * @Description:
 */
public class ThreeNumberSum {
    public static List<List<Integer>> getResult(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                return result;
            }
            if (i > 0 && input[i - 1] == input[i]) {
                continue;
            }
            int right = input.length - 1;
            int left = i + 1;
            while (left < right) {
                if (input[i] + input[left] + input[right] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(input[i]);
                    temp.add(input[left]);
                    temp.add(input[right]);
                    result.add(temp);

                    while (left < right && input[right] == input[right - 1]) {
                        right--;
                    }
                    while (left < right && input[left] == input[left + 1]) {
                        left++;
                    }

                    left ++;
                    right --;
                } else if (input[i] + input[left] + input[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        ThreeNumberSum threeNumberSum = new ThreeNumberSum();
        List<List<Integer>> result = ThreeNumberSum.getResult(input);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}