package com.leetcode;

import java.util.Arrays;

/**
 * @Author: shiwei10
 * @Date: 2024/4/29 19:29
 */
public class FindContentChildren {
    public int findContentChildren(int[] stomach, int[] cookies) {
        Arrays.sort(stomach);
        Arrays.sort(cookies);
        int index = cookies.length - 1;
        int result = 0;

        for (int i = stomach.length - 1; i >= 0; i--) {
            if (index >= 0 && cookies[index] >= stomach[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
