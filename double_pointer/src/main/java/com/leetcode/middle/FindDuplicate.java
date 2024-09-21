package com.leetcode.middle;

/**
 * @author: shiwei10
 * @create: 2024-09-21 16:01
 * @Description: 287. 寻找重复数
 */
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,2};
        int temp = findDuplicate(ints);
        System.out.println(temp);
    }
}
