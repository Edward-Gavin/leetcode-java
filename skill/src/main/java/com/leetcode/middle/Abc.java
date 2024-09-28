package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 19:48
 */
public class Abc {
    public int findDuplicate(int[] nums) {

        boolean[] res = new boolean[nums.length];

        for(int i=0; i<nums.length; i++){
            if (res[nums[i]]){
                res[nums[i]] = false;
            }else{
                res[nums[i]] = true;
            }
        }


        for(int i=1; i<res.length; i++){
            if(!res[nums[i]] ){
                return i-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = {3,3,3,3,3};
        Abc abc = new Abc();
        int duplicate = abc.findDuplicate(input);
    }
}
