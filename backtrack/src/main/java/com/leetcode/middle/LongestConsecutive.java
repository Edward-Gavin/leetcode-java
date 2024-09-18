package com.leetcode.middle;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: shiwei10
 * @Date: 2024/9/18 19:12
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int length = nums.length;

        if(length == 0 || length == 1){
            return length;
        }

        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        int curCount = 1;
        int preCount = 0;

        for(int i=1; i<length; i++){
            if(nums[i-1] == nums[i]-1){
                curCount ++;
                preCount = Math.max(curCount, preCount);
            } else {
                curCount = 0;
            }
        }

        return preCount;
    }

    public static int longestConsecutiveV2(int[] nums){

        // 去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        int length = 0;
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                length ++;
                while (set.contains(i + 1)) {
                    i ++;
                    length ++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
