package com.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shiwei10
 * @Date: 2024/9/18 19:43
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){

            int temp = target-nums[i];

            if(hash.containsKey(nums[i])){
                return new int[]{i, hash.get(nums[i])};
            }else{
                hash.put(temp, i);
            }
        }

        return new int[]{};
    }
}
