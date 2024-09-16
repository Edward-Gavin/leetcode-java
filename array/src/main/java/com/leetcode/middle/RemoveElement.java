package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-09-16 20:40
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;

        int length = nums.length;

        int j = 0;

        for (int i = 0; i < length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement removeElement = new RemoveElement();
        int i = removeElement.removeElement(nums, 2);
    }
}
